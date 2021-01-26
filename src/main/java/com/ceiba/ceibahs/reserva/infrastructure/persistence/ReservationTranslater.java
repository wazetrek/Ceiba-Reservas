package com.ceiba.ceibahs.reserva.infrastructure.persistence;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationTranslater {

    public ReservationTranslater() {
    }

    public static ReservationEntity parseReservationToEntity(Reservation reservation) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(reservation.getReservationDate(), formatter);
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationDate(localDateTime);
        reservationEntity.setStatus(reservationEntity.getStatus());
        reservationEntity.setValue(reservationEntity.getValue());
        return reservationEntity;
    }
}
