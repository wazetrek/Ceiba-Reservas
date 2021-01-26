package com.ceiba.ceibahs.analista.domain.port;

import com.ceiba.ceibahs.analista.domain.model.Analyst;

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
}
