package com.vimaire.portfolio.models.student;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "student", schema = "portfolio")
@Getter
@Setter
public class Student extends AbstractIdentifier {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "dob")
    private Instant dob;

}
