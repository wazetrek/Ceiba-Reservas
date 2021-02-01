package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationDao;

import java.util.List;

public class ConsultReservationService {

    private final ReservationDao reservationDao;

    public ConsultReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public List<ReservationDto> getAllActiveReservations() {
        return reservationDao.getActiveReservations();
    }

    public ReservationDto getReservationById(Long id) {
        return reservationDao.getReservationById(id);
    }
}
