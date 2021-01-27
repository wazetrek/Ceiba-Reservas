package com.ceiba.ceibahs.analista.domain.model;

import com.ceiba.ceibahs.utils.FieldValidate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Analyst {

    private static final String FULL_NAME_OBLIGATORY = "Nombre completo obligatorio";

    private Long id;
    private String fullName;
    private String employeeCode;
    private Boolean status;
    private LocalDateTime birthDate;

    public Analyst(Long id, String fullName, String employeeCode, Boolean status, LocalDateTime birthDate) {

        FieldValidate.validateNotNull(fullName, FULL_NAME_OBLIGATORY);

        this.id = id;
        this.fullName = fullName;
        this.employeeCode = employeeCode;
        this.status = status;
        this.birthDate = birthDate;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}
