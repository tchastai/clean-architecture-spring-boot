package com.template.cleanarchitecture.hexagonal.application.dto;

import com.template.cleanarchitecture.hexagonal.domain.House;
import lombok.Data;

import java.util.UUID;

@Data
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

    public static GetHouseResponseDto mapFromHouse(House house) {
        return new GetHouseResponseDto(house.getId(), house.getAddress(), house.getCity(), house.getPrice());
    }
}
