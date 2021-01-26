package com.ceiba.ceibahs.analista.infrastructure.persistence;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AnalystBuilder {

    public AnalystBuilder() {
    }

    public static AnalystEntity parseAnalystToEntity(Analyst analyst) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(analyst.getBirthDate(), formatter);
        AnalystEntity analystEntity = new AnalystEntity();
        analystEntity.setFullName(analyst.getFullName());
        analystEntity.setEmployeeCode(analyst.getEmployeeCode());
        analystEntity.setStatus(analyst.getStatus());
        analystEntity.setBirthDate(localDateTime);
        return analystEntity;
    }

    public static AnalystDto parseAnalystToDto(AnalystEntity analystEntity) {
        return new AnalystDto(analystEntity.getId(), analystEntity.getFullName(), analystEntity.getEmployeeCode(), analystEntity.getStatus(), analystEntity.getBirthDate());
    }
}
