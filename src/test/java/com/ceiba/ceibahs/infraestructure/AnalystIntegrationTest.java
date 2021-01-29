package com.ceiba.ceibahs.infraestructure;

import com.ceiba.ceibahs.analista.appication.command.AnalystCommand;
import com.ceiba.ceibahs.utils.exception.ObligatoryFieldException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
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
class AnalystIntegrationTest {

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
    void createAnalystTest() throws Exception {

        Long id = 10L;
        String fullName = "Pepe";
        String employeeCode = "1020";
        LocalDateTime birthDate = LocalDateTime.of(1999, 01, 10, 00, 00);

        AnalystCommand analystCommand = new AnalystCommand(id, fullName, employeeCode, true, birthDate);
        mockMvc.perform( MockMvcRequestBuilders
                .post("/analyst")
                .content(objectMapper.writeValueAsString(analystCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createAnalystWithoutNameTest() throws Exception {

        Long id = 10L;
        String employeeCode = "1020";
        LocalDateTime birthDate = LocalDateTime.of(1999, 01, 10, 00, 00);

        AnalystCommand analystCommand = new AnalystCommand(id, null, employeeCode, true, birthDate);
        mockMvc.perform( MockMvcRequestBuilders
                .post("/analyst")
                .content(objectMapper.writeValueAsString(analystCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()
            );
    }
}
