package com.ceiba.ceibahs.utils.enums;

/**
 * Estados por los que puede pasar una reserva
 */
public enum ReservationStatus {
    /**
     * Al crear la reserva, entra en estado activo directamente
     */
    ACTIVE,
    /**
     * Al modificar la reserva ingresando el diagnóstico pasa a estado finalizado
     */
    FINALIZED,
    /**
     * Si la reserva es cancelada, se incluye un estado cancelado
     */
    CANCELLED
}
