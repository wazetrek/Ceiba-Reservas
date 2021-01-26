package com.ceiba.ceibahs.analista.infrastructure.persistence.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ANALYST")
@NamedQuery(name="Analysts.byActiveStatus" , query="SELECT ans FROM ANALYST ans WHERE ans.status = TRUE")
@Data
public class AnalystEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "analyst_seq")
    @SequenceGenerator(name = "analyst_seq", sequenceName = "analyst_seq")
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "EMPLOYEE_CODE")
    private String employeeCode;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "BIRTH_DATE")
    private LocalDateTime birthDate;
}
