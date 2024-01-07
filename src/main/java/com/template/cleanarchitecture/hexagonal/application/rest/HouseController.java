package com.template.cleanarchitecture.hexagonal.application.rest;

import com.template.cleanarchitecture.hexagonal.domain.dto.CreateHouseRequestDto;
import com.template.cleanarchitecture.hexagonal.domain.dto.CreateHouseResponseDto;
import com.template.cleanarchitecture.hexagonal.domain.dto.GetHouseResponseDto;
import com.template.cleanarchitecture.hexagonal.domain.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public ResponseEntity<CreateHouseResponseDto> createHouse(@RequestBody final CreateHouseRequestDto createHouseRequestDto) {
        final UUID id = houseService.create(createHouseRequestDto);
        return ResponseEntity.ok(new CreateHouseResponseDto(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetHouseResponseDto> getHouse(@PathVariable("id") final String id) {
        return ResponseEntity.ok(houseService.getHouse(id));
    }

}
