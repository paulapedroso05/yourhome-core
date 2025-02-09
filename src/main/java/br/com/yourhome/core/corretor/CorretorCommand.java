package br.com.yourhome.core.corretor;

import br.com.yourhome.core.binder.corretor.CorretorCadastradoMessage;
import br.com.yourhome.core.configuracao.MessageSourceHelper;
import br.com.yourhome.core.configuracao.exception.ConflictException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CorretorCommand {

    private final CorretorRepository corretorRepository;

    private final MessageSourceHelper messageSourceHelper;

    public Corretor handle(CorretorCadastradoMessage message) {
        ofNullable(corretorRepository.findCorretorByCreci(message.getCreci())).ifPresent(existente -> {
            throw new ConflictException(messageSourceHelper.getMessage("corretor.conflito", message.getCreci()));
        });
        return corretorRepository.save(message.to());
    }

}
