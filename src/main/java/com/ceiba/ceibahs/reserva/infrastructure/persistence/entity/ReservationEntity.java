package com.ceiba.ceibahs.reserva.infrastructure.persistence.entity;

import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "RESERVATION")
@Data
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANALYST_ID")
    private AnalystEntity analyst;

    @Column(name = "RESERVATION_DATE")
    private LocalDateTime reservationDate;

    @Column(name = "VALUE")
    private int value;

    @Column(name = "DIAGNOSIS")
    private String diagnosis;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ReservationStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @Column(name = "DOLLAR_VALUE")
    private int dollarValue;
}
