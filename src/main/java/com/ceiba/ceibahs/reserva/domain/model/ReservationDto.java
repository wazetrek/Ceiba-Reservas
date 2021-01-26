package com.ceiba.ceibahs.reserva.domain.model;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationDto {

    private Long id;
    private Analyst analyst;
    private String reservationDate;
    private String value;
    private String diagnosis;
    private String status;

}
