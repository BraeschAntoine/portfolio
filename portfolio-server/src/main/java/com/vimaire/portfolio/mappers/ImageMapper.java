package com.vimaire.portfolio.mappers;

import com.vimaire.portfolio.api.dto.ImageDto;
import com.vimaire.portfolio.mappers.generic.BaseMapper;
import com.vimaire.portfolio.models.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseMapper<Image, ImageDto> {
}
