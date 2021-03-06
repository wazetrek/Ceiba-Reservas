package com.ceiba.ceibahs.analista.infrastructure.persistence.repository;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;
import com.ceiba.ceibahs.analista.infrastructure.persistence.AnalystTranslater;
import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AnalystPersistenceRepository implements AnalystRepository {

    private final EntityManager entityManager;

    public AnalystPersistenceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Analyst create(Analyst analyst) {

        AnalystEntity analystEntity = AnalystTranslater.parseAnalystToEntity(analyst);
        analystEntity.setStatus(true);
        entityManager.persist(analystEntity);
        entityManager.flush();
        return new Analyst(
                analystEntity.getId(),
                analystEntity.getFullName(),
                analystEntity.getEmployeeCode(),
                analystEntity.getStatus(),
                analystEntity.getBirthDate()
        );
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void changeStatus(Long id) {

    }
}
