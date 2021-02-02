package com.ceiba.ceibahs.analista.infrastructure.persistence.repository;

import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalystRepositoryJPA extends JpaRepository<AnalystEntity, Long> {


}
