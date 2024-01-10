package com.cleanarchitecture.hexagonal.application.dto;


import com.cleanarchitecture.House;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseRequestDto {
    @NotEmpty
    @NotNull
    private String address;

    @NotEmpty
    @NotNull
    private String city;

    @NotEmpty
    @NotNull
    private Integer price;

    public House mapToHouse() {
        return new House(getAddress(), getCity(), getPrice());
    }
}
