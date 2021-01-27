package com.ceiba.ceibahs.utils.exception;

public class ReservationDayNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Excepción para cuando el día de la reserva no es un día válido
     * @param message
     */
    public ReservationDayNotValidException(String message) {
        super(message);
    }
}
