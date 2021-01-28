package com.ceiba.ceibahs.domain.unit;

import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.testdatabuilder.ReservationTestDataBuilder;
import com.ceiba.ceibahs.utils.exception.NoZeroValueException;
import com.ceiba.ceibahs.utils.exception.ObligatoryFieldException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ReservationTest {

    private static final LocalDateTime RESERVATION_DATE = LocalDateTime.of(2030, 01, 10, 9, 00, 00);

    @Test
    void correctReservationCreationTest() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE);

        Reservation reservation = reservationTestDataBuilder.build();

        assertEquals(RESERVATION_DATE, reservation.getReservationDate());
    }

    @Test
    void undatedReservationCreationTest() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .reservationDateNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "La fecha de reserva es obligatoria");
    }

    @Test
    void creationOfReservationWithZeroValueTest() {

        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .valueZero();

        Throwable throwable = assertThrows(NoZeroValueException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "El valor de reserva es obligatorio");
    }

    @Test
    void creationOfReservationWithNullAnalystTest() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .analystNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "La reserva debe tener un analista seleccionado");
    }

    @Test
    void creationOfReservationWithPaymentTypeNullTest() {
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .paymentTypeNull();

        Throwable throwable = assertThrows(ObligatoryFieldException.class, reservationTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "Debe seleccionar un tipo de pago");
    }
}
