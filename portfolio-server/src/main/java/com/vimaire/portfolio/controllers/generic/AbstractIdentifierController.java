package com.vimaire.portfolio.controllers.generic;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import com.vimaire.portfolio.api.endpoints.generic.IAbstractIdentifierCrud;
import com.vimaire.portfolio.mappers.generic.BaseMapper;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractIdentifierService;
import com.vimaire.portfolio.utils.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
public abstract class AbstractIdentifierController<DTO extends AbstractIdentifierDto, MODEL extends AbstractIdentifier, SERVICE extends IAbstractIdentifierService<MODEL>, MAPPER extends BaseMapper<MODEL, DTO>>
        implements IAbstractIdentifierCrud<DTO> {


    @Autowired
    protected transient SERVICE service;

    @Autowired
    protected transient MAPPER mapper;

    @Override
    public ResponseEntity<DTO> create(DTO pRequest) throws CustomException {
        final MODEL model = mapper.dtoToModel(pRequest);
        return new ResponseEntity<>(mapper.modelToDto(service.create(model)),
                HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<List<DTO>> findAll() {
        return new ResponseEntity<>(mapper.modelListToDtoList(service.findAll()
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> get(String pUuid){
        return new ResponseEntity<>(mapper.modelToDto(service.findByUuid(pUuid)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DTO> update(DTO pRequest) throws CustomException {
        final MODEL model = mapper.dtoToModel(pRequest);
        return new ResponseEntity<>(mapper.modelToDto(service.update(model)),
                HttpStatus.CREATED);
    }

    @Override
    public void delete(@RequestParam(name = "uuid") String pUuid) throws CustomException {
        service.delete(pUuid);
    }

    @Override
    public ResponseEntity save(@RequestBody List<DTO> pDtoList) throws CustomException {
        List<MODEL> models = mapper.dtoListToModelList(pDtoList);

        return new ResponseEntity(mapper.modelListToDtoList(service.save(models)), HttpStatus.ACCEPTED);
    }
}
