package com.template.cleanarchitecture.hexagonal.domain.service;

import com.template.cleanarchitecture.hexagonal.domain.House;
import com.template.cleanarchitecture.hexagonal.domain.dto.CreateHouseRequestDto;
import com.template.cleanarchitecture.hexagonal.domain.dto.GetHouseResponseDto;

import java.util.UUID;

public interface HouseService {
    UUID create(CreateHouseRequestDto createHouseRequestDto);

    GetHouseResponseDto getHouse(String id);

}
