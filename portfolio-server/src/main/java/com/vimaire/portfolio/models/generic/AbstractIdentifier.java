package com.vimaire.portfolio.models.generic;

import com.vimaire.portfolio.utils.utils.IdentifierUtils;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractIdentifier implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @PrePersist
    @PreUpdate
    public void onCreateOrUpdate(){
        if(StringUtils.isBlank(id.toString())) {
            setId(IdentifierUtils.generateUUID());
        }
    }


}
