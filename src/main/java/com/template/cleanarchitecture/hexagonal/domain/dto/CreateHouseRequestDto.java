package com.template.cleanarchitecture.hexagonal.domain.dto;


import lombok.Data;


public class CreateHouseRequestDto {
    private String address;
    private String city;
    private Integer price;

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
