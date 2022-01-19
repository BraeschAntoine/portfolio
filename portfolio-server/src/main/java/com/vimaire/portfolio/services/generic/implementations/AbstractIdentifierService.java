package com.vimaire.portfolio.services.generic.implementations;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.repository.generic.IAbstractIdentifierRepository;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractIdentifierService;
import com.vimaire.portfolio.utils.enums.ErrorEnum;
import com.vimaire.portfolio.utils.exception.CustomException;
import com.vimaire.portfolio.utils.utils.IdentifierUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Transactional
public abstract class AbstractIdentifierService<MODEL extends AbstractIdentifier, REPOSITORY extends IAbstractIdentifierRepository<MODEL>>
        extends AbstractService<MODEL, UUID, REPOSITORY>
        implements IAbstractIdentifierService<MODEL> {


    public List<MODEL> findAllByUuids(final Set<UUID> pUuids) throws CustomException{
        if(pUuids.isEmpty()){
            throw new CustomException(ErrorEnum.LIST_EMPTY);
        }
        return this.repository.findAllByIdIn(pUuids);
    }

    public MODEL findByUuid(final UUID pUuid){
        return repository.findById(pUuid).orElse(null);
    }

    public void deleteAllByUuid(final Set<UUID> pUuids){

    }

    @Override
    public MODEL create(MODEL pModel) throws CustomException {
        if(StringUtils.isBlank(pModel.getId().toString())) {
            pModel.setId(IdentifierUtils.generateUUID());
        }
        return super.create(pModel);
    }

    @Override
    public MODEL update(MODEL pModel) throws CustomException {
        if(StringUtils.isBlank(pModel.getId().toString()) || ObjectUtils.isEmpty(pModel)){
            throw new CustomException(ErrorEnum.SAVING_NULL);
        }
        MODEL dbModel = repository.findById(pModel.getId()).orElse(null);
        if(ObjectUtils.isEmpty(dbModel)){
            throw new CustomException(ErrorEnum.NOT_IN_DB);
        }
        pModel.setId(dbModel.getId());
        return super.update(pModel);
    }

    @Override
    public List<MODEL> save(final List<MODEL> pModels) throws CustomException {
        if(pModels.isEmpty()) {
            throw new CustomException(ErrorEnum.LIST_EMPTY);
        }
        List<MODEL> response= new ArrayList<>();
        for(MODEL model : pModels) {
            if(StringUtils.isBlank(model.getId().toString())) {
                response.add(create(model));
            } else {
                response.add(update(model));
            }
        }
        return response;
    }


    @Override
    public void delete(final UUID pUuid) throws CustomException{
        if(StringUtils.isBlank(pUuid.toString())) {
            throw new CustomException(ErrorEnum.NO_UUID_PROVIDED);
        }
        MODEL dbModel = repository.findById(pUuid).orElse(null);
        if(ObjectUtils.isEmpty(dbModel)) {
            throw new CustomException(ErrorEnum.NOT_IN_DB);
        }
        beforeDelete(dbModel);
        repository.deleteById(pUuid);
    }
}
