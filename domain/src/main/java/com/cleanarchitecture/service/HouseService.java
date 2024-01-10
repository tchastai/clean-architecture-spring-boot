package com.cleanarchitecture.service;

import com.cleanarchitecture.House;

import java.util.UUID;

public interface HouseService {
    UUID create(House house);

    House getHouse(String id);

}
