package com.vimaire.portfolio.controllers;

import com.vimaire.portfolio.api.dto.UserDto;
import com.vimaire.portfolio.api.endpoints.UserApi;
import com.vimaire.portfolio.config.AuthenticatedUser;
import com.vimaire.portfolio.controllers.generic.AbstractIdentifierFilterController;
import com.vimaire.portfolio.mappers.UserMapper;
import com.vimaire.portfolio.models.User;
import com.vimaire.portfolio.models.filter.UserFilter;
import com.vimaire.portfolio.services.implementations.UserService;
import com.vimaire.portfolio.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
        extends AbstractIdentifierFilterController<UserDto, User, UserFilter, UserService, UserMapper>
        implements UserApi {

    @Autowired
    AuthenticatedUser user;

    @Override
    //@PreAuthorize("hasRole('admin')") au choix, si je veux utiliser juste le nom du role ou le prefix + role
    @Secured({"ROLE_user"})
    public UserDto getConnectedUser() {
        return mapper.modelToDto(service.getConnectedUser());
    }

    @Override
    @Secured({"ROLE_admin"})
    public ResponseEntity<UserDto> create(UserDto pRequest) throws CustomException {
        return super.create(pRequest);
    }
}
