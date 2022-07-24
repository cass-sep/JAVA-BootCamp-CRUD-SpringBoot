package com.paizao.messenger.service;

import org.springframework.stereotype.Service;

import com.paizao.messenger.core.crud.ServiceCrud;
import com.paizao.messenger.domain.Contato;

@Service
public class ContatoService extends ServiceCrud<Contato, Long> {

    @Override
    protected Contato editarEntidade(Contato recuperado, Contato entidade) {
        recuperado.setNome(entidade.getNome());

        return recuperado;
    }
}
