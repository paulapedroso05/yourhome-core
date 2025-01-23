package br.com.yourhome.core.binder.corretor;

import br.com.yourhome.core.corretor.CorretorCommand;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorretorListener {

    private final CorretorCommand corretorCommand;

    @RabbitListener(queues = {"queuecorretor"})
    public void receiveMessage(final CorretorCadastradoMessage message) {
        corretorCommand.handle(message);
    }

}
