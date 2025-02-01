package br.com.yourhome.core.binder.corretor;

import br.com.yourhome.core.corretor.Corretor;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CorretorCadastradoMessage implements Serializable {

    private String creci;

    private String nome;

    private String email;

    private String telefone;

    private String bio;

    private List<String> tiposImoveis;

    private List<String> construtoras;

    private List<String> cidades;

    private List<String> bairros;

    public Corretor to() {
        return Corretor.of(null, creci, nome, email, telefone, bio, tiposImoveis, construtoras, cidades, bairros);
    }

}
