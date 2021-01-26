package com.ceiba.ceibahs.analista.domain.port;

import com.ceiba.ceibahs.analista.domain.model.AnalystDto;

import java.util.List;

public interface AnalystDao {

    /**
     * Permite consultar todos los analistas
     * @return Lista de analistas
     */
    List<AnalystDto> getAnalysts();
}
