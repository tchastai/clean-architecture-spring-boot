package com.cleanarchitecture;


import com.cleanarchitecture.constant.ExceptionConstant;
import com.cleanarchitecture.exception.DomainException;

import java.util.*;

public class House {

    private UUID id;
    private String address;
    private String city;

    private Integer price;

    public House(String address, String city, Integer price) {
        if(address == null || address.isEmpty() || address.isBlank()) {
            throw new DomainException(ExceptionConstant.EXCEPTION_ADDRESS_CANNOT_BE_NULL_MESSAGE);
        }
        if(city == null || city.isEmpty() || city.isBlank()) {
            throw new DomainException(ExceptionConstant.EXCEPTION_CITY_CANNOT_BE_NULL_MESSAGE);
        }
        if(price == null || price.toString().length() < 4) {
            throw new DomainException(ExceptionConstant.EXCEPTION_PRICE_CANNOT_BE_NULL_MESSAGE);
        }
        this.id = UUID.randomUUID();
        this.address = address;
        this.city = city;
        this.price = price;
    }

    public House(UUID id, String address, String city, Integer price) {
        if(address == null || address.isEmpty() || address.isBlank()) {
            throw new DomainException(ExceptionConstant.EXCEPTION_ADDRESS_CANNOT_BE_NULL_MESSAGE);
        }
        if(city == null || city.isEmpty() || city.isBlank()) {
            throw new DomainException(ExceptionConstant.EXCEPTION_CITY_CANNOT_BE_NULL_MESSAGE);
        }
        if(price == null || price.toString().length() < 4) {
            throw new DomainException(ExceptionConstant.EXCEPTION_PRICE_CANNOT_BE_NULL_MESSAGE);
        }
        this.id = UUID.randomUUID();
        this.address = address;
        this.city = city;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
