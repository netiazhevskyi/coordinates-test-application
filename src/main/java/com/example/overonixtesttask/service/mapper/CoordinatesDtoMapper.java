package com.example.overonixtesttask.service.mapper;

import com.example.overonixtesttask.model.Coordinates;
import com.example.overonixtesttask.model.dto.CoordinatesResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesDtoMapper implements DtoMapper<CoordinatesResponseDto, Coordinates> {
    @Override
    public Coordinates toModel(CoordinatesResponseDto responseDto) {
        Coordinates coordinates = new Coordinates();
        coordinates.setLongitude(responseDto.getLon());
        coordinates.setLatitude(responseDto.getLat());
        return coordinates;
    }

    @Override
    public CoordinatesResponseDto toDto(Coordinates model) {
        CoordinatesResponseDto coordinatesResponseDto = new CoordinatesResponseDto();
        coordinatesResponseDto.setId(model.getId());
        coordinatesResponseDto.setLat(model.getLatitude());
        coordinatesResponseDto.setLon(model.getLongitude());
        return coordinatesResponseDto;
    }
}
