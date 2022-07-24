package com.paizao.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paizao.messenger.domain.Contato;
import com.paizao.messenger.service.ContatoService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/contatos")
public class ContatosController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> listar() {
        List<Contato> contatos = contatoService.listar();

        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> especifico(@PathVariable("id") Long id) {
        Contato resultado = contatoService.porId(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato) {
        Contato salvo = contatoService.criar(contato);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> editar(@PathVariable("id") Long id, @RequestBody Contato contato) {
        Contato resultado = contatoService.porId(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contatoService.editar(id, contato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        Contato resultado = contatoService.porId(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        contatoService.excluir(id);

        return ResponseEntity.ok().build();
    }
}
