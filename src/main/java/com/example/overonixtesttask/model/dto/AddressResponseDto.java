package com.example.overonixtesttask.model.dto;

import java.util.Map;

public class AddressResponseDto {
    private Map<String, String> addressDetails;

    public Map<String, String> getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(Map<String, String> addressDetails) {
        this.addressDetails = addressDetails;
    }
}
