package br.com.yourhome.core.corretor.clienteweb;

import br.com.monkey.ecx.annotation.SearchParameter;
import br.com.yourhome.core.corretor.Corretor;
import br.com.yourhome.core.corretor.CorretorQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/usuarios/{idUsuario}/corretores")
public class ClienteCorretorRestController {

    private final CorretorQuery corretorQuery;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Corretor> listar(@SearchParameter Specification<Corretor> search,
            @PageableDefault @SortDefault.SortDefaults({
                    @SortDefault(sort = "nome", direction = Sort.Direction.ASC) }) Pageable pageable) {
        return corretorQuery.listar(search, pageable);
    }

}
