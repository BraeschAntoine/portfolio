package com.vimaire.portfolio.models.experience;

import com.vimaire.portfolio.models.company.Company;
import com.vimaire.portfolio.models.generic.AbstractIdentifier;
import com.vimaire.portfolio.models.technology.Technology;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;

@Table(name = "experience", schema = "portfolio")
@Getter
@Setter
public class Experience extends AbstractIdentifier {

    @Column(name = "from_date")
    private Instant fromDate;

    @Column(name = "to_date")
    private Instant toDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(
            name = "experience_technologies",
            joinColumns = @JoinColumn(name = "experience_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private Set<Technology> technologies;

}
