package com.vimaire.portfolio.api.endpoints.generic;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import com.vimaire.portfolio.utils.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IAbstractIdentifierCrud<DTO extends AbstractIdentifierDto> {

    @PostMapping
    ResponseEntity<DTO> create(@RequestBody final DTO pRequest) throws CustomException;

    @GetMapping
    ResponseEntity<List<DTO>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<DTO> get(@PathVariable("id") final String pUuid);

    @PutMapping
    ResponseEntity<DTO> update(@RequestBody final DTO pRequest) throws CustomException;

    @DeleteMapping("/{id}")
    void delete(@PathVariable final String pUuid) throws CustomException;

    @PostMapping("/all")
    ResponseEntity<List<DTO>> save(@RequestBody final List<DTO> pDtoList) throws CustomException;

}
