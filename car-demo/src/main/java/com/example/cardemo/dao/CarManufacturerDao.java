package com.example.cardemo.dao;

import com.example.cardemo.entity.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarManufacturerDao extends JpaRepository<CarManufacturer, Integer> {
}
