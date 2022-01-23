package com.vimaire.portfolio.models.technology;

import com.vimaire.portfolio.models.experience.Experience;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.image.Image;
import com.vimaire.portfolio.models.project.Project;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

public class Technology extends AbstractIdentifier {

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private TechnologyTypeEnum type;

    @Column
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image logo;

    @ManyToMany
    private Set<Experience> experiences;

    @ManyToMany
    private Set<Project> projects;
}
