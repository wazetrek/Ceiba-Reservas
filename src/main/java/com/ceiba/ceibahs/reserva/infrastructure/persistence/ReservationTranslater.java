package com.ceiba.ceibahs.reserva.infrastructure.persistence;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;

public final class ReservationTranslater {

    private ReservationTranslater() {
        throw new IllegalStateException("Clase de traducción");
    }

    public static ReservationEntity parseReservationToEntity(Reservation reservation) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationDate(reservation.getReservationDate());
        reservationEntity.setStatus(reservation.getStatus());
        reservationEntity.setValue(reservation.getValue());
        reservationEntity.setPaymentType(reservation.getPaymentType());
        reservationEntity.setDollarValue(reservation.getDollarValue());
        return reservationEntity;
    }
}
