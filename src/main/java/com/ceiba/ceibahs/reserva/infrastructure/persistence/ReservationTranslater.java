package com.ceiba.ceibahs.reserva.infrastructure.persistence;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationTranslater {

    public ReservationTranslater() {
    }

    public static ReservationEntity parseReservationToEntity(Reservation reservation) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationDate(reservation.getReservationDate());
        reservationEntity.setStatus(reservationEntity.getStatus());
        reservationEntity.setValue(reservationEntity.getValue());
        return reservationEntity;
    }
}
