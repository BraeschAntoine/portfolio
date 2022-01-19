package com.vimaire.portfolio.api.dto.student;

import com.vimaire.portfolio.api.dto.generic.AbstractIdentifierDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto extends AbstractIdentifierDto {

    private String nom;
    private String email;
    private Integer age;
    private Instant dob;
}
