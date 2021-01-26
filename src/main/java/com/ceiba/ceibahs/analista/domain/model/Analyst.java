package com.ceiba.ceibahs.analista.domain.model;

import com.ceiba.ceibahs.utils.FieldValidate;
import lombok.Getter;

@Getter
public class Analyst {

    private static final String FULL_NAME_OBLIGATORY = "Nombre completo obligatorio";
    private static final String EMPLOYEE_CODE_OBLIGATORY = "Código de empleado obligatorio";
    private static final String MAX_EMPLOYEE_CODE_ERROR = "La cantidad de caracteres del código de empleado es erronea";
    private static final Long MAX_EMPLOYEE_CODE_CHARACTERS = 10L;

    private Long id;
    private String fullName;
    private String employeeCode;
    private Boolean status;
    private String birthDate;

    public Analyst(Long id, String fullName, String employeeCode, Boolean status, String birthDate) {

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
