package com.ceiba.ceibahs.utils.exception;

public class NoValidReservationValueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoValidReservationValueException(String message) {
        super(message);
    }
}
