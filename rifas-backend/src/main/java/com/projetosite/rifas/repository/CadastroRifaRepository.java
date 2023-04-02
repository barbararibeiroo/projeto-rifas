package com.projetosite.rifas.repository;


import com.projetosite.rifas.model.CadastroRifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRifaRepository extends JpaRepository<CadastroRifa, Long> {


}
