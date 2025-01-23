package br.com.yourhome.core.binder.corretor;

import br.com.yourhome.core.corretor.Corretor;
import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CorretorCadastradoMessage implements Serializable {

    private String documento;

    private String nome;

    private String email;

    private String telefone;

    private String creci;

    private String bio;

    public Corretor to() {
        return Corretor.of(documento, nome, email, telefone, creci, bio);
    }

}
