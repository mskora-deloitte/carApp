package com.dolittle.carApp.dao;

import com.dolittle.carApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByTypeAndBrand(String type, String brand);
}
