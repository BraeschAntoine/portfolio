package com.vimaire.portfolio.models.company;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.image.Image;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
public class Company extends AbstractIdentifier {

    @Column()
    private String name;

    @Column()
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image logo;


}
