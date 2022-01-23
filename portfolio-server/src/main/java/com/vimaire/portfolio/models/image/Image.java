package com.vimaire.portfolio.models.image;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.project.Project;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "image", schema = "portfolio")
public class Image extends AbstractIdentifier {

    @Column()
    private String name;

    @Column()
    private String altName;

    @Column()
    private String path;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
