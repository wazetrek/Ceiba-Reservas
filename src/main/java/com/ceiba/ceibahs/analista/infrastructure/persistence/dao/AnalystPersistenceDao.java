package com.ceiba.ceibahs.analista.infrastructure.persistence.dao;

import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import com.ceiba.ceibahs.analista.domain.port.AnalystDao;
import com.ceiba.ceibahs.analista.infrastructure.persistence.AnalystTranslater;
import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnalystPersistenceDao implements AnalystDao {

    private final EntityManager entityManager;
    private static final String ACTIVE_ANALYSTS = "Analysts.byActiveStatus";

    public AnalystPersistenceDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AnalystDto> getAnalysts() {
        List<AnalystDto> analystDtos = new ArrayList<>();
        Query query = entityManager.createNamedQuery(ACTIVE_ANALYSTS);
        List<AnalystEntity> analystEntityList = query.getResultList();
        for (Object analystEntity : analystEntityList) {
            analystDtos.add(AnalystTranslater.parseAnalystToDto((AnalystEntity) analystEntity));
        }
        return analystDtos;
    }
}
