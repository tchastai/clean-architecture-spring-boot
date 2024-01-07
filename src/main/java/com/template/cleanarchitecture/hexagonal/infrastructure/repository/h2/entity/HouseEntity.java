package com.template.cleanarchitecture.hexagonal.infrastructure.repository.h2.entity;

import com.template.cleanarchitecture.hexagonal.domain.House;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseEntity {

    @Id
    private UUID id;
    private String address;
    private String city;

    private Integer price;

    public HouseEntity(House house) {
        this.id = house.getId();
        this.address = house.getAddress();
        this.city = house.getCity();
        this.price = house.getPrice();
    }

    public House toHouse() {
        return new House(getId(), getAddress(), getCity(), getPrice());
    }
}
