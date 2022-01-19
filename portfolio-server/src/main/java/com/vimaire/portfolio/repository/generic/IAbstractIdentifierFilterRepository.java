package com.vimaire.portfolio.repository.generic;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IAbstractIdentifierFilterRepository<MODEL extends AbstractIdentifier>
        extends IAbstractIdentifierRepository<MODEL>, QuerydslPredicateExecutor<MODEL> {

}
