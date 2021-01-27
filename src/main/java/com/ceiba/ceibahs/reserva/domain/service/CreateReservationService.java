package com.ceiba.ceibahs.reserva.domain.service;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.reserva.domain.model.ReservationDto;
import com.ceiba.ceibahs.reserva.domain.port.ReservationRepository;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import com.ceiba.ceibahs.utils.exception.InvalidReservationHourException;
import com.ceiba.ceibahs.utils.exception.NoValidReservationValueException;
import com.ceiba.ceibahs.utils.exception.ReservationDayNotValidException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class CreateReservationService {

    private static final String NO_VALID_RESERVATION_VALUE = "El valor de la reserva no ha podido ser calculado correctamente";
    private static final String RESERVATION_DAY_NOT_VALID  = "No es posible programar una reserva para un día domingo";
    private static final String INVALID_RESERVATION_HOUR  = "La hora seleccionada para la reserva no es válida";

    private ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDto create(Reservation reservation) {
        validateDayOfReservation(reservation.getReservationDate());
        validateInvalidHours(reservation.getReservationDate());
        validateReservationValue(reservation.getValue(), reservation.getReservationDate());
        reservation.setStatus(ReservationStatus.ACTIVE);
        return reservationRepository.create(reservation);
    }

    private void validateDayOfReservation(LocalDateTime reservationDate) {
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if (dayOfTheWeek == DayOfWeek.SUNDAY.getValue()) {
            throw new ReservationDayNotValidException(RESERVATION_DAY_NOT_VALID);
        }
    }

    private void validateInvalidHours(LocalDateTime reservationDate) {
        List<Integer> validHours = List.of(9, 10, 11, 13, 14, 15, 16, 17);
        if (!validHours.contains(reservationDate.getHour())) {
            throw new InvalidReservationHourException(INVALID_RESERVATION_HOUR);
        }
    }

    private void validateReservationValue(int value, LocalDateTime reservationDate){
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if (dayOfTheWeek == DayOfWeek.SATURDAY.getValue()) {
            if (value != 40000) {
                throw new NoValidReservationValueException(NO_VALID_RESERVATION_VALUE);
            }
        } else {
            if (value != 35000) {
                throw new NoValidReservationValueException(NO_VALID_RESERVATION_VALUE);
            }
        }
    };
}
