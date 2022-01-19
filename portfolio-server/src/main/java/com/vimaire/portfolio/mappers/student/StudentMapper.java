package com.vimaire.portfolio.mappers.student;

import com.vimaire.portfolio.api.dto.student.StudentDto;
import com.vimaire.portfolio.mappers.generic.BaseMapper;
import com.vimaire.portfolio.models.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<Student, StudentDto> {

    @Mapping(target = "nom", source = "name")
    StudentDto modelToDto(Student pStudent);

    @Mapping(target = "name", source = "nom")
    Student dtoToModel(StudentDto pStudentDto);
}
