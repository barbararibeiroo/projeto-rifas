package com.projetosite.rifas.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroRifa {

    private String nomeRifa;
    private String telefoneSuporte;
    private Integer qtdBilhetes;
    private Double precoBilhete;
    private Integer qtdBilhetePorCarrinho;
    private Integer tempoExpiracaoReservaNaoPaga;
    private String localSorteioBilhete;



}
