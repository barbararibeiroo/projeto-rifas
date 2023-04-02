package com.projetosite.rifas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroUsuario {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

}
