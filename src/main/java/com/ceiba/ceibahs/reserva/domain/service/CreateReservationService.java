package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;

public class CreateReservationService {

    private final ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long create(Reservation reservation) {
        reservation.validatePreviousDays(reservation.getReservationDate());
        reservation.setStatus(ReservationStatus.ACTIVE);
        return reservationRepository.create(reservation);
    }
}
