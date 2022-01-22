package com.vimaire.portfolio.models.student.filter;

import com.vimaire.portfolio.models.generic.AbstractFilters;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.vimaire.portfolio.models.student.QStudent;

public class StudentFilters extends AbstractFilters {

    private static final QStudent student = QStudent.student;

    public static BooleanExpression isNameEquals(String name) {
        return student.name.eq(name);
    }

    public static BooleanExpression isAgedMore(Integer age) {
        return student.age.gt(age);
    }
}
