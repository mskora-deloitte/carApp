package com.dolittle.carApp.controller;

import com.dolittle.carApp.dao.CarRepository;
import com.dolittle.carApp.model.Car;
import com.dolittle.carApp.service.CarService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car request) {
        return carService.addCar(request);
    }

    @DeleteMapping("/deleteCar")
    public String deleteCar(@RequestBody Long id) {
        return carService.deleteCar(id) ? "Successfully deleted car" : "No car with such ID";
    }

    @PatchMapping("/patchCar")
    public String patchCar(@RequestBody Car request) {
        return carService.patchCar(request) ? "Successfully patched car" : "No car with such ID";
    }

}
