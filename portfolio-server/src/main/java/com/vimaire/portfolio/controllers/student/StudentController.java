package com.vimaire.portfolio.controllers.student;

import com.vimaire.portfolio.api.dto.student.StudentDto;
import com.vimaire.portfolio.api.endpoints.student.IStudent;
import com.vimaire.portfolio.config.AuthenticatedUser;
import com.vimaire.portfolio.controllers.generic.AbstractIdentifierFilterController;
import com.vimaire.portfolio.mappers.student.StudentMapper;
import com.vimaire.portfolio.models.student.Student;
import com.vimaire.portfolio.models.student.StudentFilter;
import com.vimaire.portfolio.services.generic.implementations.KeycloakService;
import com.vimaire.portfolio.services.student.interfaces.IStudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StudentController
      extends AbstractIdentifierFilterController<StudentDto, Student, StudentFilter, IStudService, StudentMapper>
        implements IStudent {

    private final KeycloakService keycloak;

    private final AuthenticatedUser user;

    StudentController(KeycloakService pKeycloak, AuthenticatedUser pUser){
        keycloak = pKeycloak;
        user = pUser;
    }

}
