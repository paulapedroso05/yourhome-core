package br.com.yourhome.core.configuracao;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_CORRETOR = "queuecorretor";

    public static final String EXCHANGE_CORRETOR = "corretor";

    @Bean
    public TopicExchange exchangeCorretor() {
        return new TopicExchange(EXCHANGE_CORRETOR, true, false);
    }

    @Bean
    public Queue queueCorretor() {
        return new Queue(QUEUE_CORRETOR, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queueCorretor()).to(exchangeCorretor()).with("routing.key.#");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
