package com.dolittle.carApp.repository;

import com.dolittle.carApp.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
