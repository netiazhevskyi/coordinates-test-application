package com.example.overonixtesttask.service.impl;

import com.example.overonixtesttask.model.Coordinates;
import com.example.overonixtesttask.model.dto.AddressResponseDto;
import com.example.overonixtesttask.service.AddressService;
import com.example.overonixtesttask.service.CoordinatesService;
import com.example.overonixtesttask.service.HttpRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private static final String url = "https://nominatim.openstreetmap.org/";
    private final HttpRequestService httpRequestService;
    private final CoordinatesService coordinatesService;

    public AddressServiceImpl(HttpRequestService httpRequestService,
                              CoordinatesService coordinatesService) {
        this.httpRequestService = httpRequestService;
        this.coordinatesService = coordinatesService;
    }

    @Override
    public List<AddressResponseDto> getAllAddresses() {
        List<Coordinates> allCoordinates = coordinatesService.getAllCoordinates();
        return allCoordinates.stream()
                .map(this::parseDataToMap)
                .collect(Collectors.toList());
    }

    private AddressResponseDto parseDataToMap(Coordinates coordinates) {
        String urlRequest = url + String.format("reverse?format=json&lon=%s&lat=%s",
                coordinates.getLongitude(), coordinates.getLatitude());
        try {
            String httpGetRequest = httpRequestService.sendHttpGetRequest(urlRequest);
            Map<String, Object> addressMap = new ObjectMapper()
                    .readValue(httpGetRequest, Map.class);
            Map<String, String> addressResponseMap
                    = (Map<String, String>) addressMap.get("address");
            AddressResponseDto addressResponseDto = new AddressResponseDto();
            addressResponseDto.setAddressDetails(addressResponseMap);
            return addressResponseDto;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get response by url: " + urlRequest);
        }
    }
}
