package com.vimaire.portfolio.repository.generic;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Set;

@NoRepositoryBean
public interface IAbstractIdentifierRepository<MODEL extends AbstractIdentifier> extends  IAbstractRepository<MODEL, Long>{

    List<MODEL> findAllByUuidIn(final Set<String> pUuids);

    MODEL findByUuid(final String pUuid);

    void deleteByUuid(final String pUuid);
}
