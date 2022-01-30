package com.vimaire.portfolio.services.implementations;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.vimaire.portfolio.models.User;
import com.vimaire.portfolio.models.filter.UserFilter;
import com.vimaire.portfolio.repository.UserRepository;
import com.vimaire.portfolio.services.generic.implementations.AbstractIdentifierFilterService;
import com.vimaire.portfolio.services.interfaces.IUserService;
import com.vimaire.portfolio.utils.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
        extends AbstractIdentifierFilterService<User, UserFilter, UserRepository>
        implements IUserService {

    @Override
    public List<BooleanExpression> findAllFilter() {
        return null;
    }

    @Override
    public List<BooleanExpression> getFilter(UserFilter pUserFilter) {
        return null;
    }

    @Override
    protected void beforeCreate(User pModel) throws CustomException {

    }

    @Override
    protected void beforeUpdate(User pModel) throws CustomException {

    }

    @Override
    protected void beforeDelete(User pModel) {

    }
}
