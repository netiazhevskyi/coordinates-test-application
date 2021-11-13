package com.example.overonixtesttask.service.impl;

import com.example.overonixtesttask.dao.CoordinatesDao;
import com.example.overonixtesttask.model.Coordinates;
import com.example.overonixtesttask.model.dto.CoordinatesResponseDto;
import com.example.overonixtesttask.service.CoordinatesService;
import com.example.overonixtesttask.service.HttpRequestService;
import com.example.overonixtesttask.service.mapper.DtoMapper;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {
    private static final String urlToApi = "https://nominatim.openstreetmap.org/";
    private final HttpRequestService httpRequestService;
    private final CoordinatesDao coordinatesDao;
    private final DtoMapper<CoordinatesResponseDto, Coordinates> dtoMapper;

    public CoordinatesServiceImpl(HttpRequestService httpRequestService,
                                  CoordinatesDao coordinatesDao,
                                  DtoMapper<CoordinatesResponseDto, Coordinates> dtoMapper) {
        this.httpRequestService = httpRequestService;
        this.coordinatesDao = coordinatesDao;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<Coordinates> getByAddress(String houseNumber, String streetNumber, String city) {
        String urlRequest = String.format("search?format=json&housenumber=%s&streetname=%s&city=%s",
                houseNumber, streetNumber, city);
        try {
            String htmlResponse = httpRequestService.sendHttpGetRequest(urlToApi + urlRequest);
            List<CoordinatesResponseDto> coordinatesResponseDtos = Arrays.asList(new Gson()
                    .fromJson(htmlResponse, CoordinatesResponseDto[].class));
            return coordinatesResponseDtos.stream()
                    .map(dtoMapper::toModel)
                    .map(coordinatesDao::save)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Unable to receive response by url: " + urlRequest, e);
        }
    }

    @Override
    public List<Coordinates> getAllCoordinates() {
        return coordinatesDao.findAll();
    }
}
