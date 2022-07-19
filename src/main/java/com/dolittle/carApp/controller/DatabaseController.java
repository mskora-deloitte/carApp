package com.dolittle.carApp.controller;

import com.dolittle.carApp.dao.*;
import com.dolittle.carApp.model.Car;
import com.dolittle.carApp.model.Employee;
import com.dolittle.carApp.model.Outpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        carRepository.save(new Car("Sedan", "Mercedes", 2010, "Red",
                2.0f, 140, 100000));
        carRepository.save(new Car("Combi", "Mercedes", 2012, "Green",
                2.0f, 120, 90000));
        Outpost outpostWro = outpostRepository.save(new Outpost("000111222", "Wroclaw"));
        Employee employee = employeeRepository.save(new Employee(Employee.Position.SALESMAN, "Adam", "Nowak"));
        outpostWro.addEmployee(employee);
        employee.setOutpost(outpostWro);
        outpostRepository.save(outpostWro);
        employeeRepository.save(employee);
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
