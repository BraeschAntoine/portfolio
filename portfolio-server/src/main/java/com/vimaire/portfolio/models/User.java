package com.vimaire.portfolio.models;

import com.vimaire.portfolio.models.Experience;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.Image;
import com.vimaire.portfolio.models.Project;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Table(name = "user", schema = "portfolio")
@Entity
public class User extends AbstractIdentifier {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Image photo;

    @Column
    private String email;

    @Column(name = "birth_date")
    private Instant birthDate;

    @Column(name = "profile_title")
    private String profileTitle;

    @Column
    private String description;

    @OneToMany(mappedBy = "user")
    private Set<Project> projects;

    @OneToMany(mappedBy = "user")
    private Set<Experience> experiences;


}
