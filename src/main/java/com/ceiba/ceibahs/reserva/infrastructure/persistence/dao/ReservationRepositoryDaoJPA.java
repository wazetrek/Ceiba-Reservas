package com.ceiba.ceibahs.reserva.infrastructure.persistence.dao;

import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepositoryDaoJPA extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByStatus(ReservationStatus reservationStatus);

    Optional<ReservationEntity> findById(Long id);
}
