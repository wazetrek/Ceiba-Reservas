package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.utils.exception.DataNoFoundException;

public class UpdateReservationService {

    private static final String RESERVATION_FOR_CANCEL_WAS_NOT_FOUND = "La reserva a cancelar no fue encontrada";
    private final ReservationRepository reservationRepository;

    public UpdateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void cancelReservation(Long id) {
        validateReservationFound(id);
        reservationRepository.cancelReservation(id);
    }

    private void validateReservationFound(Long id) {
        if (!reservationRepository.reservationExistsById(id)){
            throw new DataNoFoundException(RESERVATION_FOR_CANCEL_WAS_NOT_FOUND);
        }
    }
}
