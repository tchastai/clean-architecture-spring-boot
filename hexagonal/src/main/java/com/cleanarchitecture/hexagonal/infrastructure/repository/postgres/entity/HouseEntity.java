package com.cleanarchitecture.hexagonal.infrastructure.repository.postgres.entity;

import com.cleanarchitecture.House;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;


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
