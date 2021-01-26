package com.ceiba.ceibahs.utils.exception;

public class ObligatoryFieldException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObligatoryFieldException(String message) {
        super(message);
    }
}
