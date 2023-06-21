package com.neesis.ecom.infrastructure.config;

import com.neesis.ecom.application.repository.PriceRepository;
import com.neesis.ecom.application.service.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EComApplicationConfig {

    @Bean
    public PriceService priceService(PriceRepository priceRepository) {
        return new PriceService(priceRepository);
    }
}
