package com.projetosite.rifas.controller;

import com.projetosite.rifas.model.CadastroUsuario;
import com.projetosite.rifas.repository.CadastroUsuarioRepository;
import com.projetosite.rifas.service.CadastroUsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class CadastroUsuarioController {

    private CadastroUsuarioRepository cadastroUsuarioRepository;
    private CadastroUsuarioService cadastroUsuarioService;

    @GetMapping
    public List<CadastroUsuario> listar() {
        return cadastroUsuarioRepository.findAll();
    }

    @GetMapping("/{cadastroUsuarioId}")
    public ResponseEntity<CadastroUsuario> buscar(@PathVariable Long cadastroUsuarioId) {
        return cadastroUsuarioRepository.findById(cadastroUsuarioId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroUsuario cadastrar(@Valid @RequestBody CadastroUsuario cadastroUsuario) {
        return cadastroUsuarioService.salvar(cadastroUsuario);
    }

    @PutMapping("/{cadastroUsuarioId}")
    public ResponseEntity<CadastroUsuario> atualizaUsuario(@PathVariable Long cadastroUsuarioId, @Valid @RequestBody CadastroUsuario cadastroUsuario) {
        if (!cadastroUsuarioRepository.existsById(cadastroUsuarioId)) {
            return ResponseEntity.notFound().build();
        }
        cadastroUsuario.setId(cadastroUsuarioId);
        cadastroUsuario = cadastroUsuarioService.salvar(cadastroUsuario);
        return ResponseEntity.ok(cadastroUsuario);
    }

    @DeleteMapping("/{cadastroUsuarioId}")
    public ResponseEntity<Void> removerCadastro(@PathVariable Long cadastroUsuarioId) {
        if (!cadastroUsuarioRepository.existsById(cadastroUsuarioId)) {
            return ResponseEntity.notFound().build();
        }
        cadastroUsuarioService.excluir(cadastroUsuarioId);
        return ResponseEntity.noContent().build();
    }

}

