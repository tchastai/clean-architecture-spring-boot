package com.template.cleanarchitecture.hexagonal.application.dto;

import com.template.cleanarchitecture.hexagonal.domain.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;



public class CreateHouseResponseDto {
    private final UUID id;

    public CreateHouseResponseDto(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
