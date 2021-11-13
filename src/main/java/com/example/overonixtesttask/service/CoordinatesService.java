package com.example.overonixtesttask.service;

import com.example.overonixtesttask.model.Coordinates;
import java.util.List;

public interface CoordinatesService {
    List<Coordinates> getByAddress(String houseNumber, String streetNumber, String city);

    List<Coordinates> getAllCoordinates();
}
