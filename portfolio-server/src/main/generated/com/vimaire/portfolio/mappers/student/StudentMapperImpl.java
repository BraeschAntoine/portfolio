package com.vimaire.portfolio.mappers.student;

import com.vimaire.portfolio.api.dto.student.StudentDto;
import com.vimaire.portfolio.models.student.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T23:52:09+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public List<StudentDto> modelListToDtoList(List<Student> pModels) {
        if ( pModels == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( pModels.size() );
        for ( Student student : pModels ) {
            list.add( modelToDto( student ) );
        }

        return list;
    }

    @Override
    public List<Student> dtoListToModelList(List<StudentDto> pDtos) {
        if ( pDtos == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( pDtos.size() );
        for ( StudentDto studentDto : pDtos ) {
            list.add( dtoToModel( studentDto ) );
        }

        return list;
    }

    @Override
    public StudentDto modelToDto(Student pStudent) {
        if ( pStudent == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setNom( pStudent.getName() );
        studentDto.setIdentifier( pStudent.getIdentifier() );
        studentDto.setUuid( pStudent.getUuid() );
        studentDto.setEmail( pStudent.getEmail() );
        studentDto.setAge( pStudent.getAge() );
        studentDto.setDob( pStudent.getDob() );

        return studentDto;
    }

    @Override
    public Student dtoToModel(StudentDto pStudentDto) {
        if ( pStudentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( pStudentDto.getNom() );
        student.setIdentifier( pStudentDto.getIdentifier() );
        student.setUuid( pStudentDto.getUuid() );
        student.setEmail( pStudentDto.getEmail() );
        student.setAge( pStudentDto.getAge() );
        student.setDob( pStudentDto.getDob() );

        return student;
    }
}
