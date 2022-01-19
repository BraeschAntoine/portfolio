package com.vimaire.portfolio.services.generic.implementations;

import com.vimaire.portfolio.models.generic.AbstractFilter;
import com.vimaire.portfolio.models.generic.AbstractFilters;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.repository.generic.IAbstractIdentifierFilterRepository;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractIdentifierFilterService;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIdentifierFilterService<MODEL extends AbstractIdentifier, FILTER extends AbstractFilter, REPOSITORY extends IAbstractIdentifierFilterRepository<MODEL>>
        extends AbstractIdentifierService<MODEL, REPOSITORY>
        implements IAbstractIdentifierFilterService<MODEL, FILTER> {

    public abstract List<BooleanExpression> findAllFilter();

    public BooleanExpression createFilter(List<BooleanExpression> wholeFilter){
        if(wholeFilter.isEmpty()) {
            return AbstractFilters.all();
        }
        BooleanExpression finalFilter = null;
        for(BooleanExpression filter : wholeFilter) {
            if(ObjectUtils.isEmpty(finalFilter)) {
                finalFilter = filter;
            } else {
                finalFilter = finalFilter.and(filter);
            }

        }
        return finalFilter;
    }

    public List<MODEL> findAll(FILTER pFILTER) {
        List<MODEL> result = new ArrayList<MODEL>();
        if(ObjectUtils.isEmpty(pFILTER)) {
            repository.findAll(createFilter(findAllFilter())).forEach(result::add);
            return result;
        }
        repository.findAll(filter(pFILTER)).forEach(result::add);
        return result;
    }

    public BooleanExpression filter(FILTER pFilter){
        if(ObjectUtils.isEmpty(pFilter)) {
           return null;
        }
        return this.createFilter(getFilter(pFilter));
    }

    public abstract List<BooleanExpression> getFilter(FILTER pFILTER);

}
