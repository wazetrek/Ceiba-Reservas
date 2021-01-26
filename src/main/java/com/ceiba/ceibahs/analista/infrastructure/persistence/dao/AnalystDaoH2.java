package com.ceiba.ceibahs.analista.infrastructure.persistence.dao;

import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import com.ceiba.ceibahs.analista.domain.port.AnalystDao;
import com.ceiba.ceibahs.analista.infrastructure.persistence.AnalystBuilder;
import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnalystDaoH2 implements AnalystDao {

    private final EntityManager entityManager;
    private static final String ACTIVE_ANALYSTS = "Analysts.byActiveStatus";

    public AnalystDaoH2(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AnalystDto> getAnalysts() {
        List<AnalystDto> analystDtos = new ArrayList<>();
        Query query = entityManager.createNamedQuery(ACTIVE_ANALYSTS);
        List analystEntityList = query.getResultList();
        for (Object analystEntity : analystEntityList) {
            analystDtos.add(AnalystBuilder.parseAnalystToDto((AnalystEntity) analystEntity));
        }
        return analystDtos;
    }
}
