package com.vimaire.portfolio.api.endpoints;

import com.vimaire.portfolio.api.dto.UserDto;
import com.vimaire.portfolio.api.endpoints.generic.IAbstractIdentifierFilterCrud;
import com.vimaire.portfolio.models.filter.UserFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserApi extends IAbstractIdentifierFilterCrud<UserDto, UserFilter> {

    @GetMapping("/test")
    Object test();
}
