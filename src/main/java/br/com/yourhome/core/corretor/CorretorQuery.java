package br.com.yourhome.core.corretor;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CorretorQuery {

    private final CorretorRepository corretorRepository;

    public Page<Corretor> listar(Specification<Corretor> busca, Pageable pageable) {
        return corretorRepository.findAll(busca, pageable);
    }

}
