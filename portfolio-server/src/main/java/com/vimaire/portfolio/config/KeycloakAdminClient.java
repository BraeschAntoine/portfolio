package com.vimaire.portfolio.config;

import com.vimaire.portfolio.config.KeycloakProperties;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.keycloak.OAuth2Constants.CLIENT_CREDENTIALS;

@Component
public class KeycloakAdminClient{

    private KeycloakProperties properties;

    private KeycloakSpringBootProperties springBootProperties;

    KeycloakAdminClient(KeycloakProperties pKeycloakProperties, KeycloakSpringBootProperties pKeycloakSpringBootProperties) {
        properties = pKeycloakProperties;
        springBootProperties = pKeycloakSpringBootProperties;
    }

    public Keycloak getInstance(){
        return KeycloakBuilder.builder()
                .serverUrl(springBootProperties.getAuthServerUrl())
                .realm(springBootProperties.getRealm())
                .grantType(CLIENT_CREDENTIALS)
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .build();
    }

    public RealmResource realm() {
        return this.getInstance().realm(springBootProperties.getRealm());
    }

    public UsersResource users() {
        return this.realm().users();
    }
}
