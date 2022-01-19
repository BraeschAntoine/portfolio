package com.vimaire.portfolio.models.student;

import com.vimaire.portfolio.models.generic.AbstractFilters;
import com.querydsl.core.types.dsl.BooleanExpression;

public class StudentFilters extends AbstractFilters {

    private static final QStudent student = QStudent.student;

    public static BooleanExpression isNameEquals(String name) {
        return student.name.eq(name);
    }

    public static BooleanExpression isAgedMore(Integer age) {
        return student.age.gt(age);
    }
}
