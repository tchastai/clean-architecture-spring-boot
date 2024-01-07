package com.template.cleanarchitecture.hexagonal.infrastructure.repository.postgres;

import com.template.cleanarchitecture.hexagonal.infrastructure.repository.postgres.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface JpaHouseRepository extends JpaRepository<HouseEntity, UUID> {
}
