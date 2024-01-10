package com.cleanarchitecture.hexagonal.application.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class CreateHouseResponseDto {
    private final UUID id;

    public CreateHouseResponseDto(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
