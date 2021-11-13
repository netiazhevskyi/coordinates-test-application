package com.example.overonixtesttask.dao;

import com.example.overonixtesttask.model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesDao extends JpaRepository<Coordinates, Long> {
}
