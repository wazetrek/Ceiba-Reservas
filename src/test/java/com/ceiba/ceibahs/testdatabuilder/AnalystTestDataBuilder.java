package com.ceiba.ceibahs.testdatabuilder;

import com.ceiba.ceibahs.analista.domain.model.Analyst;

import java.time.LocalDateTime;

public class AnalystTestDataBuilder {

    private static final Long ID = 10L;
    private static final String FULL_NAME = "Carlitos Perez";
    private static final String EMPLOYEE_CODE = "1010";
    private static final Boolean STATUS = true;
    private static final LocalDateTime BIRTH_DATE = LocalDateTime.of(1999, 01, 10, 00, 00);

    private Long id;
    private String fullName;
    private String employeeCode;
    private Boolean status;
    private String birthDate;

    public AnalystTestDataBuilder() {
        this.id = ID;
        this.fullName = FULL_NAME;
        this.employeeCode = EMPLOYEE_CODE;
        this.status = STATUS;
        this.birthDate = BIRTH_DATE.toString();
    }

    public Analyst withoutFullName() {
        return new Analyst(id, null, employeeCode, status, birthDate);
    }

    public Analyst build() {
        return new Analyst(id, fullName, employeeCode, status, birthDate);
    }


}
