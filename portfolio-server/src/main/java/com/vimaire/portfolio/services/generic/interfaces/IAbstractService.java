package com.vimaire.portfolio.services.generic.interfaces;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.utils.exception.CustomException;

import java.io.Serializable;
import java.util.List;

public interface IAbstractService<MODEL extends AbstractIdentifier, ID extends Serializable> {

    MODEL get(final ID pId);

    MODEL create(final MODEL pModel) throws CustomException;

    MODEL update(final MODEL pModel) throws CustomException;

    void delete(final ID pId) throws CustomException;

    List<MODEL> findAll();

    Long count();


}
