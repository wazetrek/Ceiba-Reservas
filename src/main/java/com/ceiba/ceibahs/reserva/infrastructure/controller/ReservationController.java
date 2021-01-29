package com.ceiba.ceibahs.reserva.infrastructure.controller;

import com.ceiba.ceibahs.reserva.appication.command.ReservationCommand;
import com.ceiba.ceibahs.reserva.appication.handler.ConsultReservationHandler;
import com.ceiba.ceibahs.reserva.appication.handler.CreateReservationHandler;
import com.ceiba.ceibahs.reserva.appication.handler.UpdateReservationHandler;
import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final CreateReservationHandler createReservationHandler;
    private final ConsultReservationHandler consultReservationHandler;
    private final UpdateReservationHandler updateReservationHandler;

    public ReservationController(CreateReservationHandler createReservationHandler, ConsultReservationHandler consultReservationHandler, UpdateReservationHandler updateReservationHandler) {
        this.createReservationHandler = createReservationHandler;
        this.consultReservationHandler = consultReservationHandler;
        this.updateReservationHandler = updateReservationHandler;
    }

    @PostMapping
    public Long createReservation(@RequestBody ReservationCommand reservationCommand) {
        return createReservationHandler.execute(reservationCommand);
    }

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return consultReservationHandler.getAllActiveReservations();
    }

    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable(name = "id") Long id) {
        updateReservationHandler.cancelReservation(id);
    }
}
