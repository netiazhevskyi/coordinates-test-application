package com.example.overonixtesttask.service;

import com.example.overonixtesttask.model.dto.AddressResponseDto;
import java.util.List;

public interface AddressService {
    List<AddressResponseDto> getAllAddresses();
}
