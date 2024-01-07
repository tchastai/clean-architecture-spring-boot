package com.template.cleanarchitecture.hexagonal.application.rest;

import com.template.cleanarchitecture.hexagonal.application.dto.CreateHouseRequestDto;
import com.template.cleanarchitecture.hexagonal.application.dto.CreateHouseResponseDto;
import com.template.cleanarchitecture.hexagonal.application.dto.GetHouseResponseDto;
import com.template.cleanarchitecture.hexagonal.domain.House;
import com.template.cleanarchitecture.hexagonal.domain.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public ResponseEntity<CreateHouseResponseDto> createHouse(@RequestBody final CreateHouseRequestDto createHouseRequestDto) {
        final UUID id = houseService.create(createHouseRequestDto.mapToHouse());
        return ResponseEntity.ok(new CreateHouseResponseDto(id));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<GetHouseResponseDto> getHouse(@PathVariable("id") final String id) {
        House h = houseService.getHouse(id);
        GetHouseResponseDto res = GetHouseResponseDto.mapFromHouse(h);
        return ResponseEntity.ok(res);
    }

}
