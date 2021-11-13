package com.example.overonixtesttask.dao;

import com.example.overonixtesttask.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
