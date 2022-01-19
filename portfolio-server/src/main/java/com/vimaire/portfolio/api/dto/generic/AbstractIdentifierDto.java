package com.vimaire.portfolio.api.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractIdentifierDto implements Serializable {

    public Long identifier;

    public String uuid;
}
