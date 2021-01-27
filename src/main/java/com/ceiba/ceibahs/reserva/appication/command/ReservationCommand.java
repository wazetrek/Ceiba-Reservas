package com.ceiba.ceibahs.reserva.appication.command;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReservationCommand {

    private Long id;
    private Analyst analyst;
    private LocalDateTime reservationDate;
    private String value;
    private String diagnosis;
    private String status;

}
