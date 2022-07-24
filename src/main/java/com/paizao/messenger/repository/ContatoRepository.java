package com.paizao.messenger.repository;

import org.springframework.stereotype.Repository;

import com.paizao.messenger.core.crud.RepositoryCrud;
import com.paizao.messenger.domain.Contato;

@Repository
public interface ContatoRepository extends RepositoryCrud<Contato, Long> {
}
