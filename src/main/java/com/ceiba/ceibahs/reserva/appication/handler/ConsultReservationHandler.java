package com.ceiba.ceibahs.reserva.appication.handler;

import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.service.ConsultReservationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultReservationHandler {

    private final ConsultReservationService consultReservationService;

    public ConsultReservationHandler(ConsultReservationService consultReservationService) {
        this.consultReservationService = consultReservationService;
    }

    public List<ReservationDto> getAllActiveReservations() {
        return consultReservationService.getAllActiveReservations();
    }

    public ReservationDto getReservationById(Long id) {
        return consultReservationService.getReservationById(id);
    }
}
