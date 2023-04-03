package com.projetosite.rifas.service;

import com.projetosite.rifas.exception.NegocioException;
import com.projetosite.rifas.model.CadastroUsuario;
import com.projetosite.rifas.repository.CadastroUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CadastroUsuarioService {

    private CadastroUsuarioRepository cadastroUsuarioRepository;

    @Transactional
    public CadastroUsuario buscar(Long cadastroUsuarioId) {
        return cadastroUsuarioRepository.findById(cadastroUsuarioId)
            .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public CadastroUsuario salvar(CadastroUsuario cadastroUsuario) {
        boolean emailEmUso = cadastroUsuarioRepository.findByEmail(cadastroUsuario.getEmail())
            .stream()
            .anyMatch(cadastroUsuarioExistente -> !cadastroUsuarioExistente.equals(cadastroUsuario));

        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        return cadastroUsuarioRepository.save(cadastroUsuario);
    }

    @Transactional
    public void excluir(Long cadastroUsuarioId) {
        cadastroUsuarioRepository.deleteById(cadastroUsuarioId);

    }
}
