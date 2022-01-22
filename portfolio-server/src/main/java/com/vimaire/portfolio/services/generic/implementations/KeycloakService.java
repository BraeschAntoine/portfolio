package com.vimaire.portfolio.services.generic.implementations;

import com.vimaire.portfolio.config.KeycloakAdminClient;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeycloakService {

    private KeycloakAdminClient adminClient;

    KeycloakService(KeycloakAdminClient pKeycloakAdminClient) {
        adminClient = pKeycloakAdminClient;
    }

    public List<UserRepresentation> getUser(){
        return adminClient.users().list();
    }

}
