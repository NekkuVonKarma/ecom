package com.neesis.ecom.integration.configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class IntegrationTestDatasource extends DriverManagerDataSource {

    public IntegrationTestDatasource() {
        super.setDriverClassName("org.h2.Driver");
        super.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        super.setUsername("sa");
        super.setPassword("");
    }

}
