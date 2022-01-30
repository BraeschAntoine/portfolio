package com.vimaire.portfolio.models.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.vimaire.portfolio.models.QUser;
import com.vimaire.portfolio.models.generic.AbstractFilters;

public class UserFilters extends AbstractFilters {

    private static final QUser user = QUser.user;

    public static BooleanExpression firstNameEquals(String name) {
        return user.firstName.eq(name);
    }
}
