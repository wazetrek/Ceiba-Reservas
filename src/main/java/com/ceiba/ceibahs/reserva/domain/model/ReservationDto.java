package com.ceiba.ceibahs.reserva.domain.model;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReservationDto {

    private Long id;
    private Analyst analyst;
    private LocalDateTime reservationDate;
    private int value;
    private String diagnosis;
    private ReservationStatus status;
    private PaymentType paymentType;
    private int dollarValue;

}
