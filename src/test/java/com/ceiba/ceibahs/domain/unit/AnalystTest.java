package com.ceiba.ceibahs.domain.unit;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.testdatabuilder.AnalystTestDataBuilder;
import com.ceiba.ceibahs.utils.exception.ObligatoryFieldException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnalystTest {

    @Test
    public void testSuccessfulAnalystCreation() {
        String fullName = "Juan Camilo Perez";
        AnalystTestDataBuilder analystTestDataBuilder = new AnalystTestDataBuilder()
                .setFullName(fullName);
        Analyst analyst = analystTestDataBuilder.build();
        analyst.generateEmployeeCode();

        assertEquals(fullName, analyst.getFullName());

    }

    @Test
    public void testAnalystCreationWithNullFullName() {
        AnalystTestDataBuilder analystTestDataBuilder = new AnalystTestDataBuilder()
                .withoutFullName();
        Throwable throwable = assertThrows(ObligatoryFieldException.class, analystTestDataBuilder::build);

        assertEquals(throwable.getMessage(), "Nombre completo obligatorio");
    }
}
