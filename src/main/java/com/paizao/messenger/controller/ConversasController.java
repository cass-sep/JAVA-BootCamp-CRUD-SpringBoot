package com.paizao.messenger.controller;

import java.util.List;
import java.util.Objects;

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
import com.paizao.messenger.domain.Conversa;
import com.paizao.messenger.service.ConversaService;

@RestController
@RequestMapping("/conversas")
public class ConversasController {
    @Autowired
    private ConversaService conversaService;

    @GetMapping
    public ResponseEntity<List<Contato>> listaConversas() {
        List<Contato> conversas = conversaService.conversasLista();

        return ResponseEntity.ok(conversas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Conversa>> especifico(@PathVariable("id") Long id) {
        List<Conversa> resultado = conversaService.porContato(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Conversa> criar(@RequestBody Conversa conversa) {
        Conversa salvo = conversaService.criarMensagem(conversa);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conversa> editar(@PathVariable("id") Long id, @RequestBody Conversa entidade) {
        Conversa resultado = conversaService.porId(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(conversaService.editar(id, entidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        Conversa resultado = conversaService.porId(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        conversaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
