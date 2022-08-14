package com.paizao.messenger.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paizao.messenger.core.crud.ServiceCrud;
import com.paizao.messenger.domain.Contato;
import com.paizao.messenger.domain.Conversa;
import com.paizao.messenger.repository.ContatoRepository;
import com.paizao.messenger.repository.ConversaRepository;

@Service
public class ConversaService extends ServiceCrud<Conversa, Long> {

    @Override
    protected Conversa editarEntidade(Conversa recuperado, Conversa entidade) {
        recuperado.setMsg(entidade.getMsg());

        return recuperado;
    }

    @Autowired
    private ConversaRepository conversaRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Conversa> porContato(Long contatoId) {
        return conversaRepository.findByContatoOrderByData(contatoId);
    }

    public Conversa criarMensagem(Conversa conversa) {
        if (conversa.getData() == null) {
            LocalDateTime agora = LocalDateTime.now();
            conversa.setData(agora);
        }
        return conversaRepository.save(conversa);
    }

    public List<Contato> conversasLista() {
        List<Conversa> conversando = conversaRepository.findByContato();
        List<Contato> contatosLista = new ArrayList<>();

        for (Conversa conversa : conversando) {
            contatosLista.add(contatoRepository.findById(conversa.getContato()).orElse(null));
        }

        return contatosLista;
    }

}
