package com.cleanarchitecture.service;

import com.cleanarchitecture.House;
import com.cleanarchitecture.exception.DomainException;
import com.cleanarchitecture.repository.HouseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DomainHouseServiceTest {
    @Test
    void testCreate() {
        // Arrange
        HouseRepository houseRepository = Mockito.mock(HouseRepository.class);
        DomainHouseService houseService = new DomainHouseService(houseRepository);

        House house = new House("123 Main St", "Cityville", 500000);

        // Act
        UUID createdHouseId = houseService.create(house);

        // Assert
        assertNotNull(createdHouseId);
        verify(houseRepository, times(1)).save(house);
    }

    @Test
    void testGetHouseFound() {
        // Arrange
        HouseRepository houseRepository = Mockito.mock(HouseRepository.class);
        DomainHouseService houseService = new DomainHouseService(houseRepository);

        UUID houseId = UUID.randomUUID();
        House expectedHouse = new House(houseId, "456 Elm St", "Townsville", 600000);

        // Act
        when(houseRepository.findById(houseId)).thenReturn(Optional.of(expectedHouse));
        House actualHouse = houseService.getHouse(houseId.toString());

        // Assert
        assertNotNull(actualHouse);
        assertEquals(expectedHouse, actualHouse);
        verify(houseRepository, times(1)).findById(houseId);
    }

    @Test
    void testGetHouseNotFound() {
        // Arrange
        HouseRepository houseRepository = Mockito.mock(HouseRepository.class);
        DomainHouseService houseService = new DomainHouseService(houseRepository);

        UUID nonExistingHouseId = UUID.randomUUID();

        // Act & Assert
        when(houseRepository.findById(nonExistingHouseId)).thenReturn(Optional.empty());
        assertThrows(DomainException.class, () -> houseService.getHouse(nonExistingHouseId.toString()));
        verify(houseRepository, times(1)).findById(nonExistingHouseId);
    }

}
