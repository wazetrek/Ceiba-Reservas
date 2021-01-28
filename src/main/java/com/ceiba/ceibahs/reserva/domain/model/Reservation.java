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
    private static final String ANALYST_OBLIGATORY = "La reserva debe tener un analista seleccionado";
    private static final String PAYMENT_TYPE_OBLIGATORY = "Debe seleccionar un tipo de pago";

    private final Long id;
    private final Analyst analyst;
    private final LocalDateTime reservationDate;
    private int value;
    private final String diagnosis;
    private ReservationStatus status;
    private final PaymentType paymentType;
    private final int dollarValue;

    public Reservation(Long id, Analyst analyst, LocalDateTime reservationDate, int value, String diagnosis, PaymentType paymentType, int dollarValue) {

        FieldValidate.validateNotNull(reservationDate, RESERVATION_DATE_OBLIGATORY);
        FieldValidate.validateNotNull(value, VALUE_OBLIGATORY);
        FieldValidate.validateNotZeroValue(value, VALUE_OBLIGATORY);
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

    public void setValue(int value) {
        this.value = value;
    }
}
