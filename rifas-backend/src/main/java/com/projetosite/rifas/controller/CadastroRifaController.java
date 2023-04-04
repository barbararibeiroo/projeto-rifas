package com.projetosite.rifas.controller;

import com.projetosite.rifas.model.CadastroRifa;
import com.projetosite.rifas.repository.CadastroRifaRepository;
import com.projetosite.rifas.service.CadastroRifaService;
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
@RequestMapping("/cadastroRifa")
public class CadastroRifaController {

    private CadastroRifaRepository cadastroRifaRepository;
    private CadastroRifaService cadastroRifaService;

    @GetMapping
    public List<CadastroRifa> listar() {
        return cadastroRifaRepository.findAll();
    }

    @GetMapping("/{cadastroRifaId}")
    public ResponseEntity<CadastroRifa> buscar(@PathVariable Long cadastroRifaId) {
        return cadastroRifaRepository.findById(cadastroRifaId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroRifa cadastrar(@Valid @RequestBody CadastroRifa cadastroRifa) {
        return cadastroRifaService.salvarRifa(cadastroRifa);
    }

    @PutMapping("/{cadastroRifaId}")
    public ResponseEntity<CadastroRifa> atualizaRifa(@PathVariable Long cadastroRifaId, @Valid @RequestBody CadastroRifa cadastroRifa) {
        if (!cadastroRifaRepository.existsById(cadastroRifaId)) {
            return ResponseEntity.notFound().build();
        }
        cadastroRifa.setId(cadastroRifaId);
        cadastroRifa = cadastroRifaService.salvarRifa(cadastroRifa);
        return ResponseEntity.ok(cadastroRifa);
    }

    @DeleteMapping("/{cadastroRifaId}")
    public ResponseEntity<Void> removerCadastro(@PathVariable Long cadastroRifaId) {
        if (!cadastroRifaRepository.existsById(cadastroRifaId)) {
            return ResponseEntity.notFound().build();
        }
        cadastroRifaService.excluir(cadastroRifaId);
        return ResponseEntity.noContent().build();
    }


}
