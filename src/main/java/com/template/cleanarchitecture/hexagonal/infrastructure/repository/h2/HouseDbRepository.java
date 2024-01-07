package com.template.cleanarchitecture.hexagonal.infrastructure.repository.h2;


import com.template.cleanarchitecture.hexagonal.domain.House;
import com.template.cleanarchitecture.hexagonal.domain.repository.HouseRepository;
import com.template.cleanarchitecture.hexagonal.infrastructure.repository.h2.entity.HouseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class HouseDbRepository implements HouseRepository {

    private static final Logger logger = LoggerFactory.getLogger(HouseDbRepository.class);

    private final JpaHouseRepository jpaHouseRepository;


    @Autowired
    public HouseDbRepository(JpaHouseRepository jpaHouseRepository) {
        this.jpaHouseRepository = jpaHouseRepository;
    }

    @Override
    public Optional<House> findById(UUID id) {
        logger.info("findById method have been called with id={}",id);
        return Optional.ofNullable(jpaHouseRepository.findById(id).get().toHouse());
    }

    @Override
    public void save(House house) {
        logger.info("save method have been called with id={}",house.getId());
        jpaHouseRepository.save(new HouseEntity(house));
    }
}
