package com.vimaire.portfolio.repository.generic;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@NoRepositoryBean
public interface IAbstractIdentifierRepository<MODEL extends AbstractIdentifier> extends  IAbstractRepository<MODEL, UUID>{

    List<MODEL> findAllByIdIn(final Set<UUID> pUuids);

}
