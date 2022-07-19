package com.dolittle.carApp.controller;

import com.dolittle.carApp.model.Car;
import com.dolittle.carApp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private static class CarMaintainerModel {
        Long carId;
        Long employeeId;

        public CarMaintainerModel(Long carId, Long employeeId) {
            this.carId = carId;
            this.employeeId = employeeId;
        }

        public Long getCarId() {
            return carId;
        }

        public void setCarId(Long carId) {
            this.carId = carId;
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
        }
    }

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

    @PatchMapping("/addCarMaintainer")
    public String addCarMaintainer(@RequestBody CarMaintainerModel carMaintainerModel) {
        Long carId = carMaintainerModel.getCarId();
        Long employeeId = carMaintainerModel.getEmployeeId();
        return carService.addCarMaintainer(carId, employeeId) ?
                "Successfully added car maintainer"
                :
                "No such car or/and employee with given ID";
    }

}
