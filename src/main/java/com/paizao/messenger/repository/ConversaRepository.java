package com.paizao.messenger.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paizao.messenger.core.crud.RepositoryCrud;
import com.paizao.messenger.domain.Conversa;

import java.util.List;

@Repository
public interface ConversaRepository extends RepositoryCrud<Conversa, Long> {
    List<Conversa> findByContatoOrderByData(Long contatoId);

    @Query(value = "SELECT *" +
            "FROM `conversa`" +
            "GROUP BY contato", nativeQuery = true)
    List<Conversa> findByContato();
}
