package com.ceiba.ceibahs.reserva.domain.model;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.utils.FieldValidate;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.enums.ReservationStatus;
import com.ceiba.ceibahs.utils.exception.InvalidReservationHourException;
import com.ceiba.ceibahs.utils.exception.NoValidReservationValueException;
import com.ceiba.ceibahs.utils.exception.ReservationDayNotValidException;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Reservation {

    private static final String RESERVATION_DATE_OBLIGATORY = "La fecha de reserva es obligatoria";
    private static final String VALUE_OBLIGATORY = "El valor de reserva es obligatorio";
    private static final String ANALYST_OBLIGATORY = "La reserva debe tener un analista seleccionado";
    private static final String PAYMENT_TYPE_OBLIGATORY = "Debe seleccionar un tipo de pago";
    private static final String INVALID_RESERVATION_VALUE = "El valor de la reserva no ha podido ser calculado correctamente";
    private static final String RESERVATION_DAY_NOT_VALID = "No es posible programar una reserva para un día domingo";
    private static final String INVALID_RESERVATION_DATE = "No es posible programar una reserva para un día y hora anterior al actual";
    private static final String INVALID_RESERVATION_HOUR = "La hora seleccionada para la reserva no es válida";

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

        validateThatTheReservationDayIsNotSunday(reservationDate);
        validateInvalidHours(reservationDate);
        validateReservationValue(value, reservationDate);

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

    public int calculateMoneyChange(int value, int dollarValue) {
        double result = (double) value /  (double) dollarValue;
        return (int) Math.ceil(result);
    }

    /**
     * Nos permite validar que no seleccionemos fecha y hora anteriores a la actual.
     * @param localDateTime
     */
    public void validatePreviousDays(LocalDateTime localDateTime) {
        LocalDateTime currentLocalDateTime = LocalDateTime.now().plusMinutes(30);
        if (localDateTime.isBefore(currentLocalDateTime)) {
            throw new InvalidReservationHourException(INVALID_RESERVATION_DATE);
        }
    }

    public void validateThatTheReservationDayIsNotSunday(LocalDateTime reservationDate) {
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if (dayOfTheWeek == DayOfWeek.SUNDAY.getValue()) {
            throw new ReservationDayNotValidException(RESERVATION_DAY_NOT_VALID);
        }
    }

    public void validateInvalidHours(LocalDateTime reservationDate) {
        List<Integer> weekValidHours = List.of(9, 10, 11, 13, 14, 15, 16, 17);
        List<Integer> saturdayValidHours = List.of(9, 10, 11, 13, 14);
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if ((dayOfTheWeek == DayOfWeek.SATURDAY.getValue() && !saturdayValidHours.contains(reservationDate.getHour()))
                || (dayOfTheWeek != DayOfWeek.SUNDAY.getValue() && !weekValidHours.contains(reservationDate.getHour()))) {
            throw new InvalidReservationHourException(INVALID_RESERVATION_HOUR);
        }
    }

    public void validateReservationValue(int value, LocalDateTime reservationDate){
        int dayOfTheWeek = reservationDate.getDayOfWeek().getValue();
        if (dayOfTheWeek == DayOfWeek.SATURDAY.getValue()) {
            if (value != 40000) {
                throw new NoValidReservationValueException(INVALID_RESERVATION_VALUE);
            }
        } else {
            if (value != 35000) {
                throw new NoValidReservationValueException(INVALID_RESERVATION_VALUE);
            }
        }
    }
}
