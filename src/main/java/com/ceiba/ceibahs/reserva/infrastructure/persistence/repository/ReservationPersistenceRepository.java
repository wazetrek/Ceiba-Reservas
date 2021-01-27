package com.ceiba.ceibahs.reserva.infrastructure.persistence.repository;

import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.ReservationTranslater;
import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ReservationPersistenceRepository implements ReservationRepository {

    private final EntityManager entityManager;

    public ReservationPersistenceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ReservationDto create(Reservation reservation) {
        ReservationEntity reservationEntity = ReservationTranslater.parseReservationToEntity(reservation);
        AnalystEntity analyst = entityManager.getReference(AnalystEntity.class, reservation.getAnalyst().getId());
        reservationEntity.setAnalyst(analyst);
        entityManager.persist(reservationEntity);
        entityManager.flush();
        return new ReservationDto(
                reservationEntity.getId(),
                reservation.getAnalyst(),
                reservationEntity.getReservationDate(),
                reservationEntity.getValue(),
                reservationEntity.getDiagnosis(),
                reservationEntity.getStatus(),
                reservationEntity.getPaymentType(),
                reservationEntity.getDollarValue()
        );
    }

    @Override
    public void update(Long id, String diagnosis, String status) {

    }

    @Override
    public void cancelReservation(Long id) {

    }
}
