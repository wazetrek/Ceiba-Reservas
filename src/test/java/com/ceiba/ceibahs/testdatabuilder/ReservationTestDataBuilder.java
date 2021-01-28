package com.ceiba.ceibahs.testdatabuilder;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;

import java.time.LocalDateTime;

public class ReservationTestDataBuilder {

    private static final Long ID = 10L;
    private static final Analyst ANALYST = new AnalystTestDataBuilder().build();
    private static final LocalDateTime RESERVATION_DATE = LocalDateTime.of(1999, 01, 10, 00, 00);
    private static final int VALUE = 35000;
    private static final String DIAGNOSIS = null;
    private static final ReservationStatus STATUS = ReservationStatus.ACTIVE;
    private static final PaymentType PAYMENT_TYPE = PaymentType.COP;
    private static final int DOLLAR_VALUE = 3000;

    private final Long id;
    private Analyst analyst;
    private LocalDateTime reservationDate;
    private int value;
    private String diagnosis;
    private ReservationStatus status;
    private PaymentType paymentType;
    private int dollarValue;

    public ReservationTestDataBuilder() {
        this.id = ID;
        this.analyst = ANALYST;
        this.reservationDate = RESERVATION_DATE;
        this.value = VALUE;
        this.diagnosis = DIAGNOSIS;
        this.status = STATUS;
        this.paymentType = PAYMENT_TYPE;
        this.dollarValue = DOLLAR_VALUE;
    }

    public ReservationTestDataBuilder setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public ReservationTestDataBuilder setAnalyst(Analyst analyst) {
        this.analyst = analyst;
        return this;
    }

    public ReservationTestDataBuilder setValue(int value) {
        this.value = value;
        return this;
    }

    public ReservationTestDataBuilder setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public ReservationTestDataBuilder setStatus(ReservationStatus status) {
        this.status = status;
        return this;
    }

    public ReservationTestDataBuilder setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public ReservationTestDataBuilder setDollarValue(int dollarValue) {
        this.dollarValue = dollarValue;
        return this;
    }

    public Reservation build() {
        return new Reservation(id, analyst, reservationDate, value, diagnosis, paymentType, dollarValue);
    }

    public ReservationTestDataBuilder reservationDateNull () {
        this.reservationDate = null;
        return this;
    }

    public ReservationTestDataBuilder valueZero () {
        this.value = 0;
        return this;
    }

    public ReservationTestDataBuilder analystNull () {
        this.analyst = null;
        return this;
    }

    public ReservationTestDataBuilder paymentTypeNull () {
        this.paymentType = null;
        return this;
    }
}
