package com.cleanarchitecture.hexagonal.infrastructure.configuration;


import com.cleanarchitecture.hexagonal.HexagonalApplication;
import com.cleanarchitecture.repository.HouseRepository;
import com.cleanarchitecture.service.DomainHouseService;
import com.cleanarchitecture.service.HouseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalApplication.class)
public class ServiceInjectionConfiguration {
    @Bean
    HouseService houseService(final HouseRepository houseRepository) {
        return new DomainHouseService(houseRepository);
    }
}
