package com.template.cleanarchitecture.hexagonal.infrastructure.repository.h2;


import com.template.cleanarchitecture.hexagonal.domain.House;
import com.template.cleanarchitecture.hexagonal.domain.repository.HouseRepository;
import com.template.cleanarchitecture.hexagonal.infrastructure.repository.h2.entity.HouseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class HouseDbRepository implements HouseRepository {

    private final JpaHouseRepository jpaHouseRepository;


    @Autowired
    public HouseDbRepository(JpaHouseRepository jpaHouseRepository) {
        this.jpaHouseRepository = jpaHouseRepository;
    }

    @Override
    public Optional<House> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(House house) {
        jpaHouseRepository.save(new HouseEntity(house));
    }
}
