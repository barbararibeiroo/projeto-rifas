package com.projetosite.rifas.service;



import com.projetosite.rifas.exception.EntidadeNaoEncontradaException;
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
    public CadastroUsuario buscar(Long usuarioId) {
        return cadastroUsuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new EntidadeNaoEncontradaException("Cadastro n�o encontrado"));

    }

    @Transactional
    public CadastroUsuario salvar(CadastroUsuario cadastroUsuario) {
        boolean emailEmUso = cadastroUsuarioRepository.findByEmail(cadastroUsuario.getEmail())
            .stream()
            .anyMatch(cadastroUsuarioExistente -> !cadastroUsuarioExistente.equals(cadastroUsuario));

        if (emailEmUso) {
            throw new NegocioException("J� existe um cliente cadastrado com este e-mail");
        }
        return cadastroUsuarioRepository.save(cadastroUsuario);
    }

    @Transactional
    public void excluir(Long usuarioId) {
        cadastroUsuarioRepository.deleteById(usuarioId);

    }
}
