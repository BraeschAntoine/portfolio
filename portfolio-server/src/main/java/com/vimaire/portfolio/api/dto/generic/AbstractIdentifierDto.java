package com.vimaire.portfolio.api.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractIdentifierDto implements Serializable {

    public UUID id;

}
