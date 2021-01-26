package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;

public class CreateReservationService {

    private ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.create(reservation);
    }
}
