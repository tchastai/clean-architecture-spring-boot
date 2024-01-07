package com.template.cleanarchitecture.hexagonal.domain.service;

import com.template.cleanarchitecture.hexagonal.domain.House;
import com.template.cleanarchitecture.hexagonal.domain.constant.ExceptionConstant;
import com.template.cleanarchitecture.hexagonal.application.dto.CreateHouseRequestDto;
import com.template.cleanarchitecture.hexagonal.application.dto.GetHouseResponseDto;
import com.template.cleanarchitecture.hexagonal.domain.exception.DomainException;
import com.template.cleanarchitecture.hexagonal.domain.repository.HouseRepository;

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
