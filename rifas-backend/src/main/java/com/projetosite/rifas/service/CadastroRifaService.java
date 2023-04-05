package com.projetosite.rifas.service;

import com.projetosite.rifas.exception.NegocioException;
import com.projetosite.rifas.model.CadastroRifa;
import com.projetosite.rifas.repository.CadastroRifaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CadastroRifaService {

    private CadastroRifaRepository cadastroRifaRepository;

    public List<CadastroRifa> listarRifas() {
        return cadastroRifaRepository.findAll();
    }

    @Transactional
    public CadastroRifa buscar(Long cadastroRifaId) {
        return cadastroRifaRepository.findById(cadastroRifaId)
            .orElseThrow(() -> new RuntimeException("rifa não encontrada"));

    }

    public CadastroRifa salvarRifa(CadastroRifa cadastroRifa) {
        return cadastroRifaRepository.save(cadastroRifa);
    }

    @Transactional
    public void excluir(Long cadastroRifaId) {
        cadastroRifaRepository.deleteById(cadastroRifaId);


    }
}
