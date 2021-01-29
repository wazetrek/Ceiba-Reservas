package com.ceiba.ceibahs.domain.unit;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.testdatabuilder.ReservationTestDataBuilder;
import com.ceiba.ceibahs.utils.enums.PaymentType;
import com.ceiba.ceibahs.utils.exception.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class ReservationTest {

    private static final LocalDateTime RESERVATION_DATE = LocalDateTime.of(2031, 01, 10, 9, 00, 00);
    private static final LocalDateTime RESERVATION_DATE_SATURDAY = LocalDateTime.of(2021, 01, 9, 9, 00, 00);
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
    void testCreationOfReservationWithPaymentTypeInUsdOnOneSaturday() {
        double value = (double) VALUE_ON_SATURDAYS / (double) DOLLAR_VALUE;
        int valueInUsd = (int) Math.ceil(value);
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE_SATURDAY)
                .setValue(VALUE_ON_SATURDAYS)
                .setPaymentType(PaymentType.USD);

        Reservation reservation = reservationTestDataBuilder.build();

        assertEquals(RESERVATION_DATE_SATURDAY, reservation.getReservationDate());
        assertEquals(valueInUsd, reservation.getValue());
    }

    @Test
    void undatedReservationCreationTest() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .reservationDateNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals("La fecha de reserva es obligatoria", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithZeroValue() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .valueZero();

        Throwable throwable = assertThrows(NoZeroValueException.class, reservationTestDataBuilder::build);

        assertEquals("El valor de reserva es obligatorio", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithNullAnalyst() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .analystNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals("La reserva debe tener un analista seleccionado", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithPaymentTypeNull() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .paymentTypeNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals("Debe seleccionar un tipo de pago", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithPreviousDate() {
        LocalDateTime previousReservationDate = LocalDateTime.of(2021, 01, 11, 9, 00, 00);
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(previousReservationDate);

        Throwable throwable = assertThrows(InvalidReservationHourException.class, reservationTestDataBuilder::validatePreviousDate);

        assertEquals("No es posible programar una reserva para un día y hora anterior al actual", throwable.getMessage());
    }

    @Test
    void testSuccessfulReservationCreationOnOneDayOfTheWeekValidatePreviousDate() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE);

        Reservation reservation = reservationTestDataBuilder.build();

        assertEquals(RESERVATION_DATE, reservation.getReservationDate());
        assertEquals(VALUE_ON_WEEKDAY, reservation.getValue());
    }

    @Test
    void testCreationOfReservationWithSundayDay() {
        LocalDateTime reservationDateSunday = LocalDateTime.of(2021, 01, 10, 9, 00, 00);
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(reservationDateSunday);

        Throwable throwable = assertThrows(ReservationDayNotValidException.class, reservationTestDataBuilder::build);

        assertEquals("No es posible programar una reserva para un día domingo", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithInvalidValueOnOneWeekDay() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .setValue(VALUE_ON_SATURDAYS);

        Throwable throwable = assertThrows(NoValidReservationValueException.class, reservationTestDataBuilder::build);

        assertEquals("El valor de la reserva no ha podido ser calculado correctamente", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithInvalidValueOnOneSaturday() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE_SATURDAY)
                .setValue(VALUE_ON_WEEKDAY);

        Throwable throwable = assertThrows(NoValidReservationValueException.class, reservationTestDataBuilder::build);

        assertEquals("El valor de la reserva no ha podido ser calculado correctamente", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithInvalidHourOnOneSaturday() {
        LocalDateTime reservationDateBadHourSaturday = LocalDateTime.of(2031, 01, 11, 8, 00, 00);
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(reservationDateBadHourSaturday)
                .setValue(VALUE_ON_SATURDAYS);

        Throwable throwable = assertThrows(InvalidReservationHourException.class, reservationTestDataBuilder::build);

        assertEquals("La hora seleccionada para la reserva no es válida", throwable.getMessage());
    }

    @Test
    void testCreationOfReservationWithInvalidHourOnOneWeekday() {
        LocalDateTime reservationDateBadHour = LocalDateTime.of(2031, 01, 10, 8, 00, 00);
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(reservationDateBadHour)
                .setValue(VALUE_ON_SATURDAYS);

        Throwable throwable = assertThrows(InvalidReservationHourException.class, reservationTestDataBuilder::build);

        assertEquals("La hora seleccionada para la reserva no es válida", throwable.getMessage());
    }

}
