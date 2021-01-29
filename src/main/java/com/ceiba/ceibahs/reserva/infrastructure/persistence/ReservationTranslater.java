package com.ceiba.ceibahs.reserva.infrastructure.persistence;

import com.ceiba.ceibahs.analista.infrastructure.persistence.AnalystTranslater;
import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
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

    public static ReservationDto parseReservationEntityToReservation(ReservationEntity reservation) {
        return new ReservationDto(
                reservation.getId(),
                AnalystTranslater.parseAnalystEntityToAnalyst(reservation.getAnalyst()),
                reservation.getReservationDate(),
                reservation.getValue(),
                reservation.getDiagnosis(),
                reservation.getStatus(),
                reservation.getPaymentType(),
                reservation.getDollarValue()
        );
    }
}
