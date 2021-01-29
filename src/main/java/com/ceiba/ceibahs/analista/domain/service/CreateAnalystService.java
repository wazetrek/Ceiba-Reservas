package com.ceiba.ceibahs.analista.domain.service;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;

import java.util.Date;

public class CreateAnalystService {

    private final AnalystRepository analystRepository;

    public CreateAnalystService(AnalystRepository analystRepository) {
        this.analystRepository = analystRepository;
    }

    public Analyst create(Analyst analyst) {
        analyst.generateEmployeeCode();
        return this.analystRepository.create(analyst);
    }
}
