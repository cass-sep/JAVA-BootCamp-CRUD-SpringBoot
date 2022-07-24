package com.paizao.messenger.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryCrud<T, ID> extends JpaRepository<T, ID> {

}
