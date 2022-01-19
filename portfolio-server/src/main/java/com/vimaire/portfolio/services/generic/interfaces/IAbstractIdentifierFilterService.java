package com.vimaire.portfolio.services.generic.interfaces;

import com.vimaire.portfolio.models.generic.AbstractFilter;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

public interface IAbstractIdentifierFilterService<MODEL extends AbstractIdentifier, FILTER extends AbstractFilter> extends IAbstractIdentifierService<MODEL>
{
    List<MODEL> findAll(FILTER pFilter);

    BooleanExpression createFilter(List<BooleanExpression> pWholeFilter);

    List<BooleanExpression> findAllFilter();

    List<BooleanExpression> getFilter(FILTER pFILTER);


}
