package com.example.overonixtesttask.service.mapper;

import com.example.overonixtesttask.model.User;
import com.example.overonixtesttask.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setEmail(user.getEmail());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }
}
