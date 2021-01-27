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

    /**
     * Nos permite validar que el día seleccionado para la reserva no sea domingo
     * @param reservationDate
     */
    private void validateDayOfReservation(LocalDateTime reservationDate) {
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if (dayOfTheWeek == DayOfWeek.SUNDAY.getValue()) {
            throw new ReservationDayNotValidException(RESERVATION_DAY_NOT_VALID);
        }
    }

    /**
     * Nos permite verificar que las horas seleccionadas para la reserva concuerden con la disponibilidad
     * de horas establecido
     * @param reservationDate
     */
    private void validateInvalidHours(LocalDateTime reservationDate) {
        List<Integer> weekValidHours = List.of(9, 10, 11, 13, 14, 15, 16, 17);
        List<Integer> saturdayValidHours = List.of(9, 10, 11, 13, 14);
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if (dayOfTheWeek == DayOfWeek.SATURDAY.getValue() && !saturdayValidHours.contains(reservationDate.getHour())) {
            throw new InvalidReservationHourException(INVALID_RESERVATION_HOUR);
        } else if (dayOfTheWeek != DayOfWeek.SUNDAY.getValue() && !weekValidHours.contains(reservationDate.getHour())) {
            throw new InvalidReservationHourException(INVALID_RESERVATION_HOUR);
        }
    }

    /**
     * Nos permite validar el valor de la reserva donde se busca evitar recibir precios no establecidos
     * @param value
     * @param reservationDate
     */
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
