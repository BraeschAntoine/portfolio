package com.vimaire.portfolio.api.endpoints.generic;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import com.vimaire.portfolio.models.generic.AbstractFilter;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface IAbstractIdentifierFilterCrud<DTO extends AbstractIdentifierDto, FILTER extends AbstractFilter> extends IAbstractIdentifierCrud<DTO>{

    @PostMapping("/filter")
    List<DTO> findAll(FILTER pFilter);
}
