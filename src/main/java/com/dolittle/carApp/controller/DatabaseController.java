package com.dolittle.carApp.controller;

import com.dolittle.carApp.dao.*;
import com.dolittle.carApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class DatabaseController {

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
        carRepository.deleteAll();
        customerRepository.deleteAll();
        employeeRepository.deleteAll();
        outpostRepository.deleteAll();
        rentalRepository.deleteAll();
        Car car = carRepository.save(new Car("Sedan", "Mercedes", 2010, "Red",
                2.0f, 140, 100000));
        carRepository.save(new Car("Combi", "Mercedes", 2012, "Green",
                2.0f, 120, 90000));
        Outpost outpostWro = outpostRepository.save(new Outpost("000111222", "Wroclaw"));
        employeeRepository.save(new Employee(Employee.Position.SALESMAN, "Adam", "Nowak", outpostWro));
        employeeRepository.save(new Employee(Employee.Position.ACCOUNTANT, "Bartek", "Kowalski", outpostWro));
        Customer customer = customerRepository.save(new Customer("Wrocław"
                , LocalDate.of(2000, 6, 3), "000333222"
                , "1234512345", "Monika", "Nowicka"));
        rentalRepository.save(new Rental(LocalDate.of(2022, 7, 26), new BigDecimal(1000)
                , outpostWro, outpostWro, car, customer));
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
