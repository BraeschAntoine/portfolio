package com.vimaire.portfolio.models;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
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

}
