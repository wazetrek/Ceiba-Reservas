package com.ceiba.ceibahs.reserva.infrastructure;

import com.ceiba.ceibahs.reserva.domain.port.ReservationDao;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.reserva.domain.service.ConsultReservationService;
import com.ceiba.ceibahs.reserva.domain.service.CreateReservationService;
import com.ceiba.ceibahs.reserva.domain.service.UpdateReservationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationServiceBean {

    @Bean
    public CreateReservationService createReservationService(ReservationRepository reservationRepository) {
        return new CreateReservationService(reservationRepository);
    }

    @Bean
    public ConsultReservationService consultReservationService(ReservationDao reservationDao) {
        return new ConsultReservationService(reservationDao);
    }

    @Bean
    public UpdateReservationService updateReservationService(ReservationRepository reservationRepository) {
        return new UpdateReservationService(reservationRepository);
    }
}
