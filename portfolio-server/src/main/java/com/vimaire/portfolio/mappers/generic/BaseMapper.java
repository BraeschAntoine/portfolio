package com.vimaire.portfolio.mappers.generic;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;

import java.util.List;

public interface BaseMapper<MODEL extends AbstractIdentifier, DTO extends AbstractIdentifierDto> {

    MODEL dtoToModel(DTO pDTO);

    DTO modelToDto(MODEL pMODEL);

    List<DTO> modelListToDtoList(List<MODEL> pModels);

    List<MODEL> dtoListToModelList(List<DTO> pDtos);
}
