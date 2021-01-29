package com.ceiba.ceibahs.reserva.appication.handler;

import com.ceiba.ceibahs.reserva.domain.service.UpdateReservationService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UpdateReservationHandler {
    private final UpdateReservationService updateReservationService;

    public UpdateReservationHandler(UpdateReservationService updateReservationService) {
        this.updateReservationService = updateReservationService;
    }

    @Transactional
    public void cancelReservation(Long id) {
        updateReservationService.cancelReservation(id);
    }
}
