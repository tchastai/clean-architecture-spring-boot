package com.cleanarchitecture.repository;


import com.cleanarchitecture.House;

import java.util.Optional;
import java.util.UUID;

public interface HouseRepository {
    Optional<House> findById(UUID id);

    void save(House house);
}
