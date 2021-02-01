package com.ceiba.ceibahs.reserva.domain.port;

import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;

import java.util.List;

public interface ReservationDao {

    /**
     * Retorna todas las reservas activas
     * @return reservas
     */
    List<ReservationDto> getActiveReservations();

    ReservationDto getReservationById(Long id);

}
