package com.template.cleanarchitecture.hexagonal.domain.service;

import com.template.cleanarchitecture.hexagonal.domain.House;

import java.util.UUID;

public interface HouseService {
    UUID create(House house);

    House getHouse(String id);

}
