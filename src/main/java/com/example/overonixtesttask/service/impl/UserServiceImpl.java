package com.example.overonixtesttask.service.impl;

import com.example.overonixtesttask.dao.UserDao;
import com.example.overonixtesttask.model.User;
import com.example.overonixtesttask.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(User user) {
        user.setPassword(user.getPassword());
        return userDao.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
