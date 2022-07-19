package com.dolittle.carApp.service;

import com.dolittle.carApp.dao.CarRepository;
import com.dolittle.carApp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public boolean deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            return false;
        }
        carRepository.deleteById(id);
        return true;
    }

    public boolean patchCar(Car patchedCar) {
        Optional<Car> optionalCar = carRepository.findById(patchedCar.getId());
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setId(patchedCar.getId());
            if (patchedCar.getType() != null) {
                car.setType(patchedCar.getType());
            }
            if (patchedCar.getBrand() != null) {
                car.setBrand(patchedCar.getBrand());
            }
            if (patchedCar.getProductionYear() != null) {
                car.setProductionYear(patchedCar.getProductionYear());
            }
            if (patchedCar.getColor() != null) {
                car.setColor(patchedCar.getColor());
            }
            if (patchedCar.getEngineCapacity() != null) {
                car.setEngineCapacity(patchedCar.getEngineCapacity());
            }
            if (patchedCar.getPower() != null) {
                car.setPower(patchedCar.getPower());
            }
            if (patchedCar.getMileage() != null) {
                car.setMileage(patchedCar.getMileage());
            }
            if (patchedCar.getRentals() != null) {
                car.setRentals(patchedCar.getRentals());
            }
            if (patchedCar.getMaintainers() != null) {
                car.setMaintainers(patchedCar.getMaintainers());
            }
            carRepository.save(car);
            return true;
        }
        return false;
    }
}
