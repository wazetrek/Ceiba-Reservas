package com.ceiba.ceibahs.reserva.infrastructure.persistence.dao;

import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationDao;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.ReservationTranslater;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationPersistenceDao implements ReservationDao {

    private final ReservationRepositoryDaoJPA reservationRepositoryDaoJPA;

    public ReservationPersistenceDao(ReservationRepositoryDaoJPA reservationRepositoryDaoJPA) {
        this.reservationRepositoryDaoJPA = reservationRepositoryDaoJPA;
    }

    @Override
    public List<ReservationDto> getActiveReservations() {
        List<ReservationEntity> reservations = reservationRepositoryDaoJPA.findByStatus(ReservationStatus.ACTIVE);
        List<ReservationDto> reservationDtos = new ArrayList<>();
        for (ReservationEntity reservation: reservations) {
            reservationDtos.add(ReservationTranslater.parseReservationEntityToReservation(reservation));
        }
        return reservationDtos;
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        return ReservationTranslater.parseReservationEntityToReservation(reservationRepositoryDaoJPA.findById(id).get());
    }
}
