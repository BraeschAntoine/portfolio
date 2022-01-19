package com.vimaire.portfolio.services.generic.interfaces;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.utils.exception.CustomException;

import java.util.List;
import java.util.Set;

public interface IAbstractIdentifierService<MODEL extends AbstractIdentifier> extends IAbstractService<MODEL, Long>{

    List<MODEL> findAllByUuids(final Set<String> pUuids) throws CustomException;

    MODEL findByUuid(final String pUuid);

    void deleteAllByUuid(final Set<String> pUuids);

    void delete(final String pUuid) throws CustomException;

    List<MODEL> save(final List<MODEL> pModels) throws CustomException;


}
