package com.vimaire.portfolio.api.endpoints.student;

import com.vimaire.portfolio.api.dto.student.StudentDto;
import com.vimaire.portfolio.api.endpoints.generic.IAbstractIdentifierFilterCrud;
import com.vimaire.portfolio.models.student.filter.StudentFilter;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/students")
public interface IStudent
       extends IAbstractIdentifierFilterCrud<StudentDto, StudentFilter>
{

}
