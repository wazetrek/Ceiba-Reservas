package com.ceiba.ceibahs.reserva.appication.command;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCommand {

    private Long id;
    private Analyst analyst;
    private LocalDateTime reservationDate;
    private int value;
    private String diagnosis;
    private PaymentType paymentType;
    private int dollarValue;

}
