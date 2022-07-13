package com.dolittle.carApp;

import com.dolittle.carApp.car.Car;
import com.dolittle.carApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
public class InitializationController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OutpostRepository outpostRepository;
    @Autowired
    private RentalRepository rentalRepository;


    @GetMapping("/initialize")
    public void initializeDatabase() {
        carRepository.save(new Car("Sedan", "Mercedes", 2010, "Red",
                2.0f, 140, 100000));
        carRepository.save(new Car("Combi", "Mercedes", 2012, "Green",
                2.0f, 120, 90000));
    }

    @GetMapping("/database")
    public Map<String, List<?>> getDatabase() {
        return Map.of("Cars", carRepository.findAll(),
                "Customers", customerRepository.findAll(),
                "Employees", employeeRepository.findAll(),
                "Outposts", outpostRepository.findAll(),
                "Rentals", rentalRepository.findAll());
    }
}
