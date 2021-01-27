package com.ceiba.ceibahs.analista.appication.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AnalystCommand {

    private Long id;
    private String fullName;
    private String employeeCode;
    private Boolean status;
    private LocalDateTime birthDate;

}
