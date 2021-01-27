package com.ceiba.ceibahs.analista.infrastructure.persistence;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;

public class AnalystTranslater {

    public AnalystTranslater() {
    }

    public static AnalystEntity parseAnalystToEntity(Analyst analyst) {
        AnalystEntity analystEntity = new AnalystEntity();
        analystEntity.setFullName(analyst.getFullName());
        analystEntity.setEmployeeCode(analyst.getEmployeeCode());
        analystEntity.setStatus(analyst.getStatus());
        analystEntity.setBirthDate(analyst.getBirthDate());
        return analystEntity;
    }

    public static AnalystDto parseAnalystToDto(AnalystEntity analystEntity) {
        return new AnalystDto(analystEntity.getId(), analystEntity.getFullName(), analystEntity.getEmployeeCode(), analystEntity.getStatus(), analystEntity.getBirthDate());
    }
}
