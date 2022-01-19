package com.vimaire.portfolio.services.generic.interfaces;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.utils.exception.CustomException;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IAbstractIdentifierService<MODEL extends AbstractIdentifier> extends IAbstractService<MODEL, UUID>{

    List<MODEL> findAllByUuids(final Set<UUID> pUuids) throws CustomException;

    MODEL findByUuid(final UUID pUuid);

    void deleteAllByUuid(final Set<UUID> pUuids);

    void delete(final UUID pUuid) throws CustomException;

    List<MODEL> save(final List<MODEL> pModels) throws CustomException;


}
