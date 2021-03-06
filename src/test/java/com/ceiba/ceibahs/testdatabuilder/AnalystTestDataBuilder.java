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
    private LocalDateTime birthDate;

    public AnalystTestDataBuilder() {
        this.id = ID;
        this.fullName = FULL_NAME;
        this.employeeCode = EMPLOYEE_CODE;
        this.status = STATUS;
        this.birthDate = BIRTH_DATE;
    }

    public AnalystTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public AnalystTestDataBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public AnalystTestDataBuilder setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public AnalystTestDataBuilder setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public AnalystTestDataBuilder withoutFullName() {
        this.fullName = null;
        return this;
    }

    public AnalystTestDataBuilder setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public Analyst build() { return new Analyst(id, fullName, employeeCode, status, birthDate); }


}
