package com.vimaire.portfolio.utils.utils;

import java.util.UUID;

public class IdentifierUtils {

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
