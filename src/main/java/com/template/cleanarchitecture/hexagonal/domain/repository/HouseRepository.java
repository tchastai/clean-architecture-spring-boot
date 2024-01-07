package com.template.cleanarchitecture.hexagonal.domain.repository;

import com.template.cleanarchitecture.hexagonal.domain.House;

import java.util.Optional;
import java.util.UUID;

public interface HouseRepository {
    Optional<House> findById(UUID id);

    void save(House house);
}
