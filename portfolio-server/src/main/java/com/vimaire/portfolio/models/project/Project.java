package com.vimaire.portfolio.models.project;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.image.Image;
import com.vimaire.portfolio.models.technology.Technology;
import com.vimaire.portfolio.models.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "project", schema = "portfolio")
public class Project extends AbstractIdentifier {

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(
            name = "project_technologies",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private Set<Technology> technologies;

    @OneToMany
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
