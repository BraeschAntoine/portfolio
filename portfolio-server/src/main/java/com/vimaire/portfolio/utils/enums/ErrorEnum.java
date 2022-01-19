package com.vimaire.portfolio.utils.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    NOT_IN_DB("Element not found in database"),

    DUPLICATED_ELEMENT("Element already existing in database"),

    NO_UUID_PROVIDED("No uuid provided"),

    NO_ID_PROVIDED("No id provided"),

    LIST_EMPTY("Provided list argument is empty"),

    SAVING_NULL("Attempting to create or update null object")
    ;


    private String message;
    ErrorEnum(String errorMessage) {
        this.message = errorMessage;
    }
}
