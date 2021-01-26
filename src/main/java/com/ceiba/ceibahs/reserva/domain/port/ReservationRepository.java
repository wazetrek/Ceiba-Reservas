package com.ceiba.ceibahs.reserva.domain.port;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;

public interface ReservationRepository {

    /**
     * Permite crear una reserva
     * @return reserva creada
     */
    public Reservation create(Reservation reservation);

    /**
     * Permite actualizar el diagnóstico y el estado de la reserva
     * @param id id de reserva
     * @param diagnosis diagnositico de la reserva
     * @param status estado de la reserva (Activa, Cancelada, Finalizada)
     */
    public void update(Long id, String diagnosis, String status);

    /**
     * Permite cambiar el estado de una reserva a cancelado
     * @param id id de reserva
     */
    public void cancelReservation(Long id);
}
