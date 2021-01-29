package com.ceiba.ceibahs.infraestructure;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;
import com.ceiba.ceibahs.analista.domain.service.CreateAnalystService;
import com.ceiba.ceibahs.reserva.domain.model.Reservation;
import com.ceiba.ceibahs.testdatabuilder.AnalystTestDataBuilder;
import com.ceiba.ceibahs.testdatabuilder.ReservationTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReservationIntegrationTest {

    private static final LocalDateTime RESERVATION_DATE = LocalDateTime.of(2031, 01, 10, 9, 00, 00);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void testCreateSuccessfulReservation() throws Exception {
        Analyst analyst = new AnalystTestDataBuilder().setId(1000L).build();
        ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
                .setReservationDate(RESERVATION_DATE)
                .setAnalyst(analyst);
        Reservation reservation = reservationTestDataBuilder.build();

        mockMvc.perform( MockMvcRequestBuilders
                .post("/reservation")
                .content(objectMapper.writeValueAsString(reservation))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
