package com.vimaire.portfolio.config;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AuthenticatedUserImpl implements AuthenticatedUser{
    @Override
    public Boolean isConnected() {
        return getPrincipal() != null;
    }

    @Override
    public Boolean isAdmin(){
        return hasRole("admin");
    }

    @Override
    public String getUserUuid() {
        KeycloakPrincipal keycloakPrincipal = getPrincipal();
        if(keycloakPrincipal == null){
            return null;
        }
        return keycloakPrincipal.getName();
    }

    @Override
    public String getEmail() {
        KeycloakPrincipal keycloakPrincipal = getPrincipal();
        if(keycloakPrincipal == null){
            return null;
        }
        return keycloakPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }

    @Override
    public Set<String> getRoles() {
        KeycloakPrincipal keycloakPrincipal = getPrincipal();
        if(keycloakPrincipal == null){
            return null;
        }
        return keycloakPrincipal.getKeycloakSecurityContext().getToken().getRealmAccess().getRoles();
    }

    @Override
    public Boolean hasRole(String role) {
        return getRoles().contains(role);
    }

    private KeycloakPrincipal getPrincipal(){
        return (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }



}
