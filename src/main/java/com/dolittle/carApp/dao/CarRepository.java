package com.dolittle.carApp.dao;

import com.dolittle.carApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
