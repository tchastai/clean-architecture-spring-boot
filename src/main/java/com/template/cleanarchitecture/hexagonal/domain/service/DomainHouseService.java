package com.template.cleanarchitecture.hexagonal.domain.service;

import com.template.cleanarchitecture.hexagonal.domain.House;
import com.template.cleanarchitecture.hexagonal.domain.constant.ExceptionConstant;
import com.template.cleanarchitecture.hexagonal.domain.dto.CreateHouseRequestDto;
import com.template.cleanarchitecture.hexagonal.domain.dto.GetHouseResponseDto;
import com.template.cleanarchitecture.hexagonal.domain.exception.DomainException;
import com.template.cleanarchitecture.hexagonal.domain.repository.HouseRepository;

import java.util.UUID;

public class DomainHouseService implements HouseService {

    private final HouseRepository houseRepository;

    public DomainHouseService(final HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }


    @Override
    public UUID create(CreateHouseRequestDto createHouseRequestDto) {
        final House house = new House(UUID.randomUUID(), createHouseRequestDto.getAddress(), createHouseRequestDto.getCity(), createHouseRequestDto.getPrice());
        houseRepository.save(house);
        return house.getId();
    }

    @Override
    public GetHouseResponseDto getHouse(String id) {
        final House house = houseRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new DomainException(ExceptionConstant.EXCEPTION_HOUSE_NOT_FOUND)
        );
        return new GetHouseResponseDto(house.getId(), house.getAddress(), house.getCity(), house.getPrice());
    }
}
