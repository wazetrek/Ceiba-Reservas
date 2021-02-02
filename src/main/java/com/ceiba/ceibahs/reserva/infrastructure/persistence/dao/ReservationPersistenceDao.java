package com.ceiba.ceibahs.reserva.infrastructure.persistence.dao;

import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationDao;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.ReservationTranslater;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import com.ceiba.ceibahs.utils.exception.DataNoFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationPersistenceDao implements ReservationDao {

    private static final String RESERVATION_NOT_FOUND = "La reserva consultada no existe";

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
        Optional<ReservationEntity> reservationEntity = reservationRepositoryDaoJPA.findById(id);
        if (!reservationEntity.isPresent()) {
            throw new DataNoFoundException(RESERVATION_NOT_FOUND);
        }
        return ReservationTranslater.parseReservationEntityToReservation(reservationEntity.get());
    }
}
