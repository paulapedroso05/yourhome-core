package br.com.yourhome.core.corretor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Document
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Corretor implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    private String creci;

    private String nome;

    private String email;

    private String telefone;

    private String bio;

    private List<String> tiposImoveis;

    private List<String> construtoras;

    private List<String> cidades;

    private List<String> bairros;

}
