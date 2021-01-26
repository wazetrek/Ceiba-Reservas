package com.ceiba.ceibahs.analista.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AnalystDto {

    private Long id;
    private String fullName;
    private String employeeCode;
    private Boolean status;
    private LocalDateTime birthDate;

}
