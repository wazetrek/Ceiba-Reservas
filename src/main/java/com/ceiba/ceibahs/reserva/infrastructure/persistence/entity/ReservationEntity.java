package com.ceiba.ceibahs.reserva.infrastructure.persistence.entity;

import com.ceiba.ceibahs.analista.infrastructure.persistence.entity.AnalystEntity;
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
    private String value;

    @Column(name = "DIAGNOSIS")
    private String diagnosis;

    @Column(name = "STATUS")
    private String status;
}
