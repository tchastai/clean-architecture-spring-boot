package com.template.cleanarchitecture.hexagonal.application.dto;


import com.template.cleanarchitecture.hexagonal.domain.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseRequestDto {
    private String address;
    private String city;
    private Integer price;

    public House mapToHouse() {
        return new House(getAddress(), getCity(), getPrice());
    }
}
