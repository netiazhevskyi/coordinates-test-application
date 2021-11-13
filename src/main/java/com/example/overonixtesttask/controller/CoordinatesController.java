package com.example.overonixtesttask.controller;

import com.example.overonixtesttask.model.Coordinates;
import com.example.overonixtesttask.model.dto.CoordinatesResponseDto;
import com.example.overonixtesttask.service.CoordinatesService;
import com.example.overonixtesttask.service.mapper.DtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CoordinatesController {
    private final CoordinatesService coordinatesService;
    private final DtoMapper<CoordinatesResponseDto, Coordinates> coordinatesDtoMapper;

    public CoordinatesController(CoordinatesService coordinatesService,
                                 DtoMapper<CoordinatesResponseDto,
                                         Coordinates> coordinatesDtoMapper) {
        this.coordinatesService = coordinatesService;
        this.coordinatesDtoMapper = coordinatesDtoMapper;
    }

    @GetMapping("/search")
    public List<CoordinatesResponseDto> getCoordinatesByAddress(@RequestParam String housenumber,
                                                         @RequestParam String streetname,
                                                         @RequestParam String city) {
        return coordinatesService
                .getByAddress(housenumber, streetname, city).stream()
                .map(coordinatesDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
