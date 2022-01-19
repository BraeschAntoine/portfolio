package com.vimaire.portfolio.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IAbstractRepository<MODEL, ID> extends JpaRepository<MODEL,ID> {
}
