package com.vimaire.portfolio.api.endpoints.student;

import com.vimaire.portfolio.api.dto.student.StudentDto;
import com.vimaire.portfolio.api.endpoints.generic.IAbstractIdentifierFilterCrud;
import com.vimaire.portfolio.models.student.StudentFilter;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/students")
public interface IStudent
       extends IAbstractIdentifierFilterCrud<StudentDto, StudentFilter>
{
    @GetMapping("/test")
    List<UserRepresentation> test();

}
