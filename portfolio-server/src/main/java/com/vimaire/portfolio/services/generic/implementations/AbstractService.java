package com.vimaire.portfolio.services.generic.implementations;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractService;
import com.vimaire.portfolio.utils.enums.ErrorEnum;
import com.vimaire.portfolio.utils.exception.CustomException;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<MODEL extends AbstractIdentifier, ID extends Serializable, REPOSITORY extends JpaRepository<MODEL, ID>> implements IAbstractService<MODEL, ID> {

    @Autowired
    protected transient REPOSITORY repository;

    protected abstract void beforeCreate(MODEL pModel) throws CustomException;

    protected abstract void beforeUpdate(MODEL pModel) throws CustomException;

    protected abstract void beforeDelete(MODEL pModel);

    protected Boolean canRead() { return true;}


    public MODEL get(ID pId) {
        return this.repository.getById(pId);
    }

    public MODEL create(MODEL pModel) throws CustomException {
       if(ObjectUtils.isEmpty(pModel)) {
           throw new CustomException(ErrorEnum.SAVING_NULL);
       }
       beforeCreate(pModel);
       return repository.save(pModel);
    }

    public MODEL update(MODEL pModel) throws CustomException {
        if(ObjectUtils.isEmpty(pModel)) {
            throw new CustomException(ErrorEnum.SAVING_NULL);
        }
        beforeUpdate(pModel);
        return repository.save(pModel);

    }

    public void delete(ID pId) throws CustomException {
        if(ObjectUtils.isEmpty(pId)) {
            throw new CustomException(ErrorEnum.NO_ID_PROVIDED);
        }
        final Optional<MODEL> model = repository.findById(pId);
        if(model.isEmpty()) {
            throw new CustomException(ErrorEnum.NOT_IN_DB);
        }
        beforeDelete(model.get());
        repository.deleteById(pId);
    }

    public List<MODEL> findAll() {
        return this.repository.findAll();
    }

    public Long count() {
        return null;
    }
}
