package com.vimaire.portfolio.models.project;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.image.Image;
import com.vimaire.portfolio.models.technology.Technology;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
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

    @OneToMany(mappedBy = "project")
    private Set<Image> images;
}
