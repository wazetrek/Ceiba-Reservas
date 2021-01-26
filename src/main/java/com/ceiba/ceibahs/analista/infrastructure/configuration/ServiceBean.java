package com.ceiba.ceibahs.analista.infrastructure.configuration;

import com.ceiba.ceibahs.analista.domain.port.AnalystDao;
import com.ceiba.ceibahs.analista.domain.port.AnalystRepository;
import com.ceiba.ceibahs.analista.domain.service.ConsultAnalystService;
import com.ceiba.ceibahs.analista.domain.service.CreateAnalystService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBean {

    @Bean
    public CreateAnalystService createAnalystService(AnalystRepository analystRepository) {
        return new CreateAnalystService(analystRepository);
    }

    @Bean
    public ConsultAnalystService consultAnalystService(AnalystDao analystDao) {
        return new ConsultAnalystService(analystDao);
    }
}
