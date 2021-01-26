package com.ceiba.ceibahs.analista.appication.factory;

import com.ceiba.ceibahs.analista.appication.command.AnalystCommand;
import com.ceiba.ceibahs.analista.domain.model.Analyst;
import org.springframework.stereotype.Component;

@Component
public class AnalystFactory {

    public Analyst createAnalyst(AnalystCommand analystCommand) {
        return new Analyst(analystCommand.getId(), analystCommand.getFullName(), analystCommand.getEmployeeCode(), analystCommand.getStatus(), analystCommand.getBirthDate());
    }
}
