package com.ceiba.ceibahs.analista.domain.port;

import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.model.AnalystDto;

import java.util.List;

public interface AnalystRepository {

    /**
     * Nos permite crear un analista
     * @param analyst
     * @return id analista
     */
    Analyst create(Analyst analyst);

    /**
     * Nos permite actualizar un analista
     * @param id
     */
    void update(Long id);

    /**
     * Nos permite activar o inactivar un analista
     * @param id
     */
    void changeStatus(Long id);

    /**
     * Valida si existe un analysta desde el código de empleado
     * @param employeeCode
     * @return existencia del empleado
     */
    boolean validateEmployeeCode(String employeeCode);

}
