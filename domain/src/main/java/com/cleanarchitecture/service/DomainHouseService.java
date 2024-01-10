package com.cleanarchitecture.service;

import com.cleanarchitecture.House;
import com.cleanarchitecture.constant.ExceptionConstant;
import com.cleanarchitecture.exception.DomainException;
import com.cleanarchitecture.repository.HouseRepository;


import java.util.UUID;

public class DomainHouseService implements HouseService {

    private final HouseRepository houseRepository;

    public DomainHouseService(final HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }


    @Override
    public UUID create(House house) {
        houseRepository.save(house);
        return house.getId();
    }

    @Override
    public House getHouse(String id) {
        return houseRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new DomainException(ExceptionConstant.EXCEPTION_HOUSE_NOT_FOUND)
        );
    }
}
