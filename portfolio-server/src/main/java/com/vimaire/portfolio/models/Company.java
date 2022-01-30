package com.vimaire.portfolio.models;

import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "company",schema = "portfolio")
public class Company extends AbstractIdentifier {

    @Column()
    private String name;

    @Column()
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image logo;

    @OneToMany(mappedBy = "company")
    private Set<Experience> experiences;

}
