package com.ceiba.ceibahs.analista.domain.model;

import com.ceiba.ceibahs.utils.FieldValidate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Analyst {

    private static final String FULL_NAME_OBLIGATORY = "Nombre completo obligatorio";

    private final Long id;
    private final String fullName;
    private String employeeCode;
    private final Boolean status;
    private final LocalDateTime birthDate;

    public Analyst(Long id, String fullName, String employeeCode, Boolean status, LocalDateTime birthDate) {

        FieldValidate.validateNotNull(fullName, FULL_NAME_OBLIGATORY);

        this.id = id;
        this.fullName = fullName;
        this.employeeCode = employeeCode;
        this.status = status;
        this.birthDate = birthDate;
    }

    public void generateEmployeeCode() {
        Long milliseconds = System.currentTimeMillis();
        this.employeeCode = milliseconds.toString();
    }
}
