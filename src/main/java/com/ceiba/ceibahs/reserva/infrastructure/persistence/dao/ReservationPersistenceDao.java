package com.ceiba.ceibahs.reserva.infrastructure.persistence.dao;

import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationPersistenceDao implements ReservationDao {

    @Override
    public List<ReservationDto> getActiveReservations() {
        return null;
    }
}
