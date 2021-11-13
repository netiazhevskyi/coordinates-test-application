package com.example.overonixtesttask.controller;

import com.example.overonixtesttask.exception.AuthenticationException;
import com.example.overonixtesttask.model.User;
import com.example.overonixtesttask.model.dto.UserLoginDto;
import com.example.overonixtesttask.model.dto.UserRegistrationDto;
import com.example.overonixtesttask.model.dto.UserResponseDto;
import com.example.overonixtesttask.service.authentication.AuthenticationService;
import com.example.overonixtesttask.service.mapper.UserMapper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody @Valid UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authenticationService.login(userLoginDto.getLogin(),
                userLoginDto.getPassword());
        return userMapper.mapToDto(user);
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegistrationDto userRequestDto) {
        User user = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userMapper.mapToDto(user);
    }
}
