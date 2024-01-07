package com.template.cleanarchitecture.hexagonal.infrastructure.configuration;


import com.template.cleanarchitecture.hexagonal.HexagonalApplication;
import com.template.cleanarchitecture.hexagonal.domain.repository.HouseRepository;
import com.template.cleanarchitecture.hexagonal.domain.service.DomainHouseService;
import com.template.cleanarchitecture.hexagonal.domain.service.HouseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalApplication.class)
public class BeanConfiguration {

    @Bean
    HouseService houseService(final HouseRepository houseRepository) {
        return new DomainHouseService(houseRepository);
    }
}
