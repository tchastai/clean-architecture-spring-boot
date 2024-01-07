package com.template.cleanarchitecture.hexagonal.domain.dto;

import java.util.UUID;

public class GetHouseResponseDto {
    private UUID id;
    private  String address;
    private String city;
    private Integer price;

    public GetHouseResponseDto(UUID id, String address, String city, Integer price) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.price = price;
    }
}
