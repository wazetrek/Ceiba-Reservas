package com.ceiba.ceibahs.reserva.appication.factory;

import com.ceiba.ceibahs.reserva.appication.command.ReservationCommand;
import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationFactory {

    public Reservation createReservation(ReservationCommand reservationCommand) {
        return new Reservation(
                reservationCommand.getId(),
                reservationCommand.getAnalyst(),
                reservationCommand.getReservationDate(),
                reservationCommand.getValue(),
                reservationCommand.getDiagnosis(),
                reservationCommand.getPaymentType(),
                reservationCommand.getDollarValue()
        );
    }
}
