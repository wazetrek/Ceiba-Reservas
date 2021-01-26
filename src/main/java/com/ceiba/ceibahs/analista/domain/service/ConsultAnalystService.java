package com.ceiba.ceibahs.analista.domain.service;

import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import com.ceiba.ceibahs.analista.domain.port.AnalystDao;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;

import java.util.List;

public class ConsultAnalystService {

    private final AnalystDao analystDao;

    public ConsultAnalystService(AnalystDao analystDao) {
        this.analystDao = analystDao;
    }

    public List<AnalystDto> getAllAnalyst() {
        return analystDao.getAnalysts();
    }
}
