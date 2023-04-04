package com.projetosite.rifas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class CadastroRifa {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=70)
    private String nomeRifa;

    @NotBlank
    @Size(max=20)
    private String telefoneSuporte;

    @NotNull
    private Integer qtdBilhetes;

    @NotNull
    private Double precoBilhete;

    @NotNull
    private Integer qtdBilhetePorCarrinho;

    @NotNull
    private Integer tempoExpiracaoReservaNaoPaga;

    @NotNull
    private String localSorteioBilhete;

}
