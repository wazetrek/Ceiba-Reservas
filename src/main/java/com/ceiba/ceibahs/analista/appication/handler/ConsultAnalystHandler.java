package com.ceiba.ceibahs.analista.appication.handler;

import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import com.ceiba.ceibahs.analista.domain.service.ConsultAnalystService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultAnalystHandler {

    private final ConsultAnalystService consultAnalystService;

    public ConsultAnalystHandler(ConsultAnalystService consultAnalystService) {
        this.consultAnalystService = consultAnalystService;
    }

    public List<AnalystDto> getAllAnalysts() {
        return consultAnalystService.getAllAnalyst();
    }
}
