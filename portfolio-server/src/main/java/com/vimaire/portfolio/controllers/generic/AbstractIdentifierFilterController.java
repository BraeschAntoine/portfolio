package com.vimaire.portfolio.controllers.generic;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import com.vimaire.portfolio.api.endpoints.generic.IAbstractIdentifierFilterCrud;
import com.vimaire.portfolio.mappers.generic.BaseMapper;
import com.vimaire.portfolio.models.generic.AbstractFilter;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractIdentifierFilterService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractIdentifierFilterController<DTO extends AbstractIdentifierDto, MODEL extends AbstractIdentifier, FILTER extends AbstractFilter, SERVICE extends IAbstractIdentifierFilterService<MODEL, FILTER>, MAPPER extends BaseMapper<MODEL, DTO>>
        extends AbstractIdentifierController<DTO, MODEL, SERVICE, MAPPER>
        implements IAbstractIdentifierFilterCrud<DTO, FILTER> {


    @Override
    public List findAll(@RequestBody FILTER pFilter) {
        return mapper.modelListToDtoList(service.findAll(pFilter));
    }
}
