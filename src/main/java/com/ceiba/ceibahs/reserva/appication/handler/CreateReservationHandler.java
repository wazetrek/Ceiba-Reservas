package com.ceiba.ceibahs.reserva.appication.handler;

import com.ceiba.ceibahs.reserva.appication.command.ReservationCommand;
import com.ceiba.ceibahs.reserva.appication.factory.ReservationFactory;
import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.service.CreateReservationService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreateReservationHandler {

    private ReservationFactory reservationFactory;
    private CreateReservationService createReservationService;

    public CreateReservationHandler(ReservationFactory reservationFactory, CreateReservationService createReservationService) {
        this.reservationFactory = reservationFactory;
        this.createReservationService = createReservationService;
    }

    @Transactional
    public ReservationDto execute(ReservationCommand reservationCommand) {
        Reservation reservation = reservationFactory.createReservation(reservationCommand);
        return createReservationService.create(reservation);
    }
}
