package com.example.overonixtesttask.service;

import com.example.overonixtesttask.model.User;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findByEmail(String email);
}
