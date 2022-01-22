package com.vimaire.portfolio.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "admin.client")
public class KeycloakProperties {

    @NotNull
    String clientId;

    @NotNull
    String clientSecret;

}
