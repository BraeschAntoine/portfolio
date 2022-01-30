package com.vimaire.portfolio.api.dto;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ImageDto extends AbstractIdentifierDto {

    private String name;

    private String altName;

    private String path;
}
