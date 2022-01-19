package com.vimaire.portfolio.utils.exception;

import com.vimaire.portfolio.utils.enums.ErrorEnum;

public class CustomException extends Exception{
    public CustomException(ErrorEnum pMessage) {
        super(pMessage.getMessage());
    }

    public CustomException(ErrorEnum pMessage, Throwable pCause) {
        super(pMessage.getMessage(), pCause);
    }

    public CustomException(String pMessage) {
        super(pMessage);
    }
}
