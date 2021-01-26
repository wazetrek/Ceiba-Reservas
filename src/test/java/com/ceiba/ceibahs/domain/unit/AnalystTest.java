package com.ceiba.ceibahs.domain.unit;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;
import com.ceiba.ceibahs.analista.domain.service.CreateAnalystService;
import com.ceiba.ceibahs.testdatabuilder.AnalystTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalystTest {

    @Test
    public void validateCorrectAnalystCreation() {
        Analyst analyst = new AnalystTestDataBuilder().build();
        AnalystRepository analystRepository = Mockito.mock(AnalystRepository.class);
        Mockito.when(analystRepository.create(analyst)).thenReturn(analyst);
        CreateAnalystService createAnalystService = new CreateAnalystService(analystRepository);
        Analyst newAnalystId = createAnalystService.create(analyst);
        assertEquals(newAnalystId, analyst);
    }
}
