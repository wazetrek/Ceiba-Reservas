package com.ceiba.ceibahs.reserva.domain.model;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import lombok.Getter;

@Getter
public class Reservation {

    private Long id;
    private Analyst analyst;
    private String reservationDate;
    private String value;
    private String diagnosis;
    private String status;

    public Reservation(Long id, Analyst analyst, String reservationDate, String value, String diagnosis, String status) {
        this.id = id;
        this.analyst = analyst;
        this.reservationDate = reservationDate;
        this.value = value;
        this.diagnosis = diagnosis;
        this.status = status;
    }
}
