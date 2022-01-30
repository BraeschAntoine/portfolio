package com.vimaire.portfolio.api.dto;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
public class UserDto extends AbstractIdentifierDto {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private Instant birthDate;

    private String description;

    private ImageDto photo;
}
