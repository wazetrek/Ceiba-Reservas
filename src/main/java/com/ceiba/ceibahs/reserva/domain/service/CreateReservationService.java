package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import com.ceiba.ceibahs.utils.exception.DataNoFoundException;

public class CreateReservationService {

    private final static String ANALYST_NOT_FOUND = "El analista seleccionado no se encuentra registrado en la aplicación";
    private final ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long create(Reservation reservation) {
        reservation.validatePreviousDays(reservation.getReservationDate());
        reservation.setStatus(ReservationStatus.ACTIVE);
        validateAnalystExists(reservation.getAnalyst().getId());
        return reservationRepository.create(reservation);
    }
    private void validateAnalystExists(Long id) {
        if(!reservationRepository.analystExistsById(id)) {
            throw new DataNoFoundException(ANALYST_NOT_FOUND);
        }
    }
}
