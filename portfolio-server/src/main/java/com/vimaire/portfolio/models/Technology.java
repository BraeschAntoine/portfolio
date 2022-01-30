package com.vimaire.portfolio.models;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "technology", schema = "portfolio")
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
