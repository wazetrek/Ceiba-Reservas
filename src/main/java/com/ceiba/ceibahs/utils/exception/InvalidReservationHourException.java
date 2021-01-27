package com.ceiba.ceibahs.utils.exception;

public class InvalidReservationHourException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidReservationHourException(String message) {
        super(message);
    }
}
