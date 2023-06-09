package com.projetosite.rifas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class CadastroUsuario  {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=70)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 55)
    private String email;

    @NotBlank
    @Size(max=20)
    private String telefone;

    @NotBlank
    @Size(max=20)
    private String senha;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
