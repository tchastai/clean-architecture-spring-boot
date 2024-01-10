package com.cleanarchitecture.hexagonal.application.rest;

import com.cleanarchitecture.House;
import com.cleanarchitecture.hexagonal.application.dto.CreateHouseRequestDto;
import com.cleanarchitecture.hexagonal.application.dto.CreateHouseResponseDto;
import com.cleanarchitecture.hexagonal.application.dto.GetHouseResponseDto;
import com.cleanarchitecture.service.HouseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class HouseControllerTest {
    @Test
    void testCreateHouse() {
        // Arrange
        HouseService houseService = Mockito.mock(HouseService.class);
        HouseController houseController = new HouseController(houseService);

        CreateHouseRequestDto requestDto = new CreateHouseRequestDto("123 Main St", "Cityville", 500000);
        UUID houseId = UUID.randomUUID();

        // Act
        when(houseService.create(any())).thenReturn(houseId);
        ResponseEntity<CreateHouseResponseDto> responseEntity = houseController.createHouse(requestDto);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(houseId, responseEntity.getBody().getId());
        verify(houseService, times(1)).create(any());
    }

    @Test
    void testGetHouse() {
        // Arrange
        HouseService houseService = Mockito.mock(HouseService.class);
        HouseController houseController = new HouseController(houseService);

        UUID houseId = UUID.randomUUID();
        House house = new House(houseId, "456 Elm St", "Townsville", 600000);

        // Act
        when(houseService.getHouse(houseId.toString())).thenReturn(house);
        ResponseEntity<GetHouseResponseDto> responseEntity = houseController.getHouse(houseId.toString());

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(house.getAddress(), responseEntity.getBody().getAddress());
        assertEquals(house.getCity(), responseEntity.getBody().getCity());
        assertEquals(house.getPrice(), responseEntity.getBody().getPrice());
        verify(houseService, times(1)).getHouse(houseId.toString());
    }
}
