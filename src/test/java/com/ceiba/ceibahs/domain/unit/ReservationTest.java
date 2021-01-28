package com.ceiba.ceibahs.domain.unit;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.testdatabuilder.ReservationTestDataBuilder;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.exception.InvalidReservationHourException;
import com.ceiba.ceibahs.utils.exception.NoZeroValueException;
import com.ceiba.ceibahs.utils.exception.ObligatoryFieldException;
import com.ceiba.ceibahs.utils.exception.ReservationDayNotValidException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ReservationTest {

    private static final LocalDateTime RESERVATION_DATE = LocalDateTime.of(2021, 01, 11, 9, 00, 00);
    private static final LocalDateTime PREVIOUS_RESERVATION_DATE = LocalDateTime.of(2021, 01, 11, 9, 00, 00);
    private static final LocalDateTime RESERVATION_DATE_SATURDAY = LocalDateTime.of(2021, 01, 9, 9, 00, 00);
    private static final LocalDateTime RESERVATION_DATE_SUNDAY = LocalDateTime.of(2021, 01, 10, 00, 00, 00);
    private static final int VALUE_ON_SATURDAYS = 40000;
    private static final int VALUE_ON_WEEKDAY = 35000;
    private static final int DOLLAR_VALUE = 3000;

    @Test
    void testSuccessfulReservationCreationOnOneDayOfTheWeek() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE);

        Reservation reservation = reservationTestDataBuilder.build();

        assertEquals(RESERVATION_DATE, reservation.getReservationDate());
        assertEquals(VALUE_ON_WEEKDAY, reservation.getValue());
    }

    @Test
    void testCreationOfReservationWithValueOfDaySaturday() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE_SATURDAY)
                .setValue(VALUE_ON_SATURDAYS);

        Reservation reservation = reservationTestDataBuilder.build();

        assertEquals(RESERVATION_DATE_SATURDAY, reservation.getReservationDate());
        assertEquals(VALUE_ON_SATURDAYS, reservation.getValue());
    }

    @Test
    void testCreationOfReservationWithPaymentTypeInUsdOnOneWeekday() {
        double value = (double) VALUE_ON_WEEKDAY / (double) DOLLAR_VALUE;
        int valueInUsd = (int) Math.ceil(value);
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .setValue(VALUE_ON_WEEKDAY)
                .setPaymentType(PaymentType.USD);

        Reservation reservation = reservationTestDataBuilder.build();

        assertEquals(RESERVATION_DATE, reservation.getReservationDate());
        assertEquals(valueInUsd, reservation.getValue());
    }

    @Test
    void undatedReservationCreationTest() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .reservationDateNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "La fecha de reserva es obligatoria");
    }

    @Test
    void testCreationOfReservationWithZeroValue() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .valueZero();

        Throwable throwable = assertThrows(NoZeroValueException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "El valor de reserva es obligatorio");
    }

    @Test
    void testCreationOfReservationWithNullAnalyst() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .analystNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "La reserva debe tener un analista seleccionado");
    }

    @Test
    void testCreationOfReservationWithPaymentTypeNull() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .paymentTypeNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "Debe seleccionar un tipo de pago");
    }

    @Test
    void testCreationOfReservationWithPreviousDate() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(PREVIOUS_RESERVATION_DATE);

        Throwable throwable = assertThrows(InvalidReservationHourException.class, reservationTestDataBuilder::validatePreviousDate);

        assertEquals(throwable.getMessage(), "No es posible programar una reserva para un día y hora anterior al actual");
    }

    @Test
    void testCreationOfReservationWithSundayDay() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE_SUNDAY);

        Throwable throwable = assertThrows(ReservationDayNotValidException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "No es posible programar una reserva para un día domingo");
    }

}
