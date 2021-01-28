package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;

public class CreateReservationService {

    private final ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDto create(Reservation reservation) {
        reservation.validatePreviousDays(reservation.getReservationDate());
        reservation.setStatus(ReservationStatus.ACTIVE);

        if (reservation.getPaymentType().equals(PaymentType.USD)) {
            reservation.setValue(reservation.calculateMoneyChange(reservation.getValue(), reservation.getDollarValue()));
        }
        return reservationRepository.create(reservation);
    }
}
