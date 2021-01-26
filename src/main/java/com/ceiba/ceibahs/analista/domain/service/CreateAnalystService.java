package com.ceiba.ceibahs.analista.domain.service;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;

import java.util.Date;

public class CreateAnalystService {

    private final String EMPLOYEE_CODE_NO_VALID = "Código de empleado no válido";
    private final AnalystRepository analystRepository;

    public CreateAnalystService(AnalystRepository analystRepository) {
        this.analystRepository = analystRepository;
    }

    public Analyst create(Analyst analyst) {
        String employeeCode = generateEmployeeCode();
        analyst.setEmployeeCode(employeeCode);
        validateEmployeeCode(analyst);
        return this.analystRepository.create(analyst);
    }

    private void validateEmployeeCode(Analyst analyst) {
        boolean exist = this.analystRepository.validateEmployeeCode(analyst.getEmployeeCode());
    }

    private String generateEmployeeCode() {
        Date date = new Date();
        String timeMilli = Long.toString(date.getTime());
        return timeMilli;
    }
}
