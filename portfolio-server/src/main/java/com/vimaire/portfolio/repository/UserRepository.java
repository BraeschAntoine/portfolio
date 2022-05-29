package com.vimaire.portfolio.repository;

import com.vimaire.portfolio.models.User;
import com.vimaire.portfolio.repository.generic.IAbstractIdentifierFilterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IAbstractIdentifierFilterRepository<User> {

    User findByEmail(String email);
}
