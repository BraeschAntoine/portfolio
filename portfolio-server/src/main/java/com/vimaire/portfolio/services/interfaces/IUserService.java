package com.vimaire.portfolio.services.interfaces;

import com.vimaire.portfolio.models.User;
import com.vimaire.portfolio.models.filter.UserFilter;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractIdentifierFilterService;

public interface IUserService extends IAbstractIdentifierFilterService<User, UserFilter> {
}
