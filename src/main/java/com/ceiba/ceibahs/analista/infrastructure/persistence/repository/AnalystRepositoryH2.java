package com.ceiba.ceibahs.analista.infrastructure.persistence.repository;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;
import com.ceiba.ceibahs.analista.infrastructure.persistence.AnalystTranslater;
import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;

@Component
public class AnalystRepositoryH2 implements AnalystRepository {

    private final EntityManager entityManager;

    public AnalystRepositoryH2(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Analyst create(Analyst analyst) {

        AnalystEntity analystEntity = AnalystTranslater.parseAnalystToEntity(analyst);
        entityManager.persist(analystEntity);
        entityManager.flush();
        return new Analyst(
                analystEntity.getId(),
                analystEntity.getFullName(),
                analystEntity.getEmployeeCode(),
                analystEntity.getStatus(),
                analystEntity.getBirthDate().toString()
        );
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void changeStatus(Long id) {

    }

    @Override
    public boolean validateEmployeeCode(String employeeCode) {
        return true;
    }
}
