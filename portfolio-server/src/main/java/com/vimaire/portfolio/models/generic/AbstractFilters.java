package com.vimaire.portfolio.models.generic;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

public abstract class AbstractFilters {

    public static BooleanExpression all() {
        return Expressions.asBoolean(true).isTrue();
    }
}
