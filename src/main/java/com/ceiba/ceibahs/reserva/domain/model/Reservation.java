package com.ceiba.ceibahs.reserva.domain.model;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.utils.FieldValidate;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reservation {

    private static final String RESERVATION_DATE_OBLIGATORY = "La fecha de reserva es obligatoria";
    private static final String VALUE_OBLIGATORY = "El valor de reserva es obligatorio";
    private static final String ANALYST_OBLIGATORY = "El valor de reserva es obligatorio";
    private static final String PAYMENT_TYPE_OBLIGATORY = "El tipo de pago es obligatorio";

    private Long id;
    private Analyst analyst;
    private LocalDateTime reservationDate;
    private int value;
    private String diagnosis;
    private ReservationStatus status;
    private PaymentType paymentType;
    private int dollarValue;

    /**
     * Constructor para crear la reserva
     * @param id
     * @param analyst
     * @param reservationDate
     * @param value
     * @param diagnosis
     * @param paymentType
     * @param dollarValue
     */
    public Reservation(Long id, Analyst analyst, LocalDateTime reservationDate, int value, String diagnosis, PaymentType paymentType, int dollarValue) {

        FieldValidate.validateNotNull(reservationDate, RESERVATION_DATE_OBLIGATORY);
        FieldValidate.validateNotNull(value, VALUE_OBLIGATORY);
        FieldValidate.validateNotNull(analyst, ANALYST_OBLIGATORY);
        FieldValidate.validateNotNull(paymentType, PAYMENT_TYPE_OBLIGATORY);

        this.id = id;
        this.analyst = analyst;
        this.reservationDate = reservationDate;
        this.value = value;
        this.diagnosis = diagnosis;
        this.paymentType = paymentType;
        this.dollarValue = dollarValue;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
