package com.template.cleanarchitecture.hexagonal.domain.dto;

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
