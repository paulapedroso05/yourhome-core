package br.com.yourhome.core.corretor;

import br.com.monkey.ecx.repository.ResourceRepository;

interface CorretorRepository extends ResourceRepository<Corretor, String> {

    Corretor findCorretorByCreci(String creci);

}
