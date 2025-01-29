package br.com.yourhome.core.corretor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface CorretorRepository extends JpaRepository<Corretor, String>, JpaSpecificationExecutor<Corretor> {
}
