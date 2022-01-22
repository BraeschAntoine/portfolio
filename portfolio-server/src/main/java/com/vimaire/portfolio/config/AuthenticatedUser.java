package com.vimaire.portfolio.config;

import java.util.Set;

public interface AuthenticatedUser {

    Boolean isConnected();

    Boolean isAdmin();

    String getUserUuid();

    Set<String> getRoles();

    Boolean hasRole(String role);

}
