package com.projetosite.rifas.repository;


import com.projetosite.rifas.model.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, Long> {
    Optional<CadastroUsuario> findByEmail(String email);


}
