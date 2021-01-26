package com.ceiba.ceibahs.analista.appication.handler;

import com.ceiba.ceibahs.analista.appication.command.AnalystCommand;
import com.ceiba.ceibahs.analista.appication.factory.AnalystFactory;
import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.service.CreateAnalystService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreateAnalystHandler {

    private final CreateAnalystService createAnalystService;
    private final AnalystFactory analystFactory;

    public CreateAnalystHandler(CreateAnalystService createAnalystService, AnalystFactory analystFactory) {
        this.createAnalystService = createAnalystService;
        this.analystFactory = analystFactory;
    }

    @Transactional
    public Analyst execute(AnalystCommand analystCommand) {
        Analyst analyst = analystFactory.createAnalyst(analystCommand);
        return createAnalystService.create(analyst);
    }
}
