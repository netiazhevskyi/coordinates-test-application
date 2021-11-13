package com.example.overonixtesttask.service.authentication;

import com.example.overonixtesttask.exception.AuthenticationException;
import com.example.overonixtesttask.model.User;

public interface AuthenticationService {
    User register(String email, String password);

    User login(String login, String password) throws AuthenticationException;
}
