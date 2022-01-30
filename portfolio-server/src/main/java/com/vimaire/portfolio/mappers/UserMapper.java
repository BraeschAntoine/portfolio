package com.vimaire.portfolio.mappers;

import com.vimaire.portfolio.api.dto.UserDto;
import com.vimaire.portfolio.mappers.generic.BaseMapper;
import com.vimaire.portfolio.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {
}
