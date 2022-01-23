package com.vimaire.portfolio.models.image;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Image extends AbstractIdentifier {

    @Column()
    private String name;

    @Column()
    private String altName;

    @Column()
    private String path;
}
