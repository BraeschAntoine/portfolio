package com.vimaire.portfolio.services.student.implementations;

import com.vimaire.portfolio.models.student.Student;
import com.vimaire.portfolio.models.student.filter.StudentFilter;
import com.vimaire.portfolio.models.student.filter.StudentFilters;
import com.vimaire.portfolio.repository.student.IStudentRepository;
import com.vimaire.portfolio.services.generic.implementations.AbstractIdentifierFilterService;
import com.vimaire.portfolio.services.student.interfaces.IStudService;
import com.vimaire.portfolio.utils.exception.CustomException;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class StudentService
        extends AbstractIdentifierFilterService<Student, StudentFilter, IStudentRepository> implements IStudService {


    public List<BooleanExpression> findAllFilter() {
        return null;
    }

    @Override
    public List<BooleanExpression> getFilter(StudentFilter pFilter){
        List<BooleanExpression> wholeFilter = new ArrayList<>();

        if(pFilter.nom != null) {
            wholeFilter.add(StudentFilters.isNameEquals(pFilter.nom));
        }
        if(pFilter.agedMore != null)
        {
            wholeFilter.add(StudentFilters.isAgedMore(pFilter.agedMore));
        }
        return wholeFilter;
    }

    @Override
    protected void beforeCreate(Student pModel) throws CustomException {

    }

    @Override
    protected void beforeUpdate(Student pModel) throws CustomException {

    }

    @Override
    protected void beforeDelete(Student pModel) {

    }
}
