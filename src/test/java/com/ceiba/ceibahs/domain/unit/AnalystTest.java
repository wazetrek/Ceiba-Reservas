package com.ceiba.ceibahs.domain.unit;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.testdatabuilder.AnalystTestDataBuilder;
import com.ceiba.ceibahs.utils.exception.ObligatoryFieldException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnalystTest {

    @Test
    void testSuccessfulAnalystCreation() {
        String fullName = "Juan Camilo Perez";
        AnalystTestDataBuilder analystTestDataBuilder = new AnalystTestDataBuilder()
                .setFullName(fullName);
        Analyst analyst = analystTestDataBuilder.build();
        analyst.generateEmployeeCode();

        assertEquals(fullName, analyst.getFullName());

    }

    @Test
    void testAnalystCreationWithNullFullName() {
        AnalystTestDataBuilder analystTestDataBuilder = new AnalystTestDataBuilder()
                .withoutFullName();
        Throwable throwable = assertThrows(ObligatoryFieldException.class, analystTestDataBuilder::build);

        assertEquals("Nombre completo obligatorio", throwable.getMessage());
    }
}
