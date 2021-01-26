package com.ceiba.ceibahs.analista.infrastructure.controller;

import com.ceiba.ceibahs.analista.appication.command.AnalystCommand;
import com.ceiba.ceibahs.analista.appication.handler.ConsultAnalystHandler;
import com.ceiba.ceibahs.analista.appication.handler.CreateAnalystHandler;
import com.ceiba.ceibahs.analista.domain.model.Analyst;
import com.ceiba.ceibahs.analista.domain.model.AnalystDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analyst")
public class AnalystController {

    private final CreateAnalystHandler createAnalystHandler;
    private final ConsultAnalystHandler consultAnalystHandler;

    public AnalystController(CreateAnalystHandler createAnalystHandler, ConsultAnalystHandler consultAnalystHandler) {
        this.createAnalystHandler = createAnalystHandler;
        this.consultAnalystHandler = consultAnalystHandler;
    }

    @PostMapping
    public Analyst createAnalyst(@RequestBody AnalystCommand analystCommand) {
        return createAnalystHandler.execute(analystCommand);
    }

    @GetMapping
    public List<AnalystDto> getAnalysts(){
        return consultAnalystHandler.getAllAnalysts();
    }
}
