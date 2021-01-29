package com.ceiba.ceibahs.reserva.infrastructure.persistence.repository;

import com.ceiba.ceibahs.reserva.infrastructure.persistence.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepositoryJPA extends JpaRepository<ReservationEntity, Long> {

    Optional<ReservationEntity> findById(Long id);

}
