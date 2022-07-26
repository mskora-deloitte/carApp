package com.dolittle.carApp.service;

import com.dolittle.carApp.dao.CarRepository;
import com.dolittle.carApp.dao.EmployeeRepository;
import com.dolittle.carApp.model.Car;
import com.dolittle.carApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

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
//            if (patchedCar.getRentals() != null) {
//                car.setRentals(patchedCar.getRentals());
//            }
            if (patchedCar.getMaintainers() != null) {
                car.setMaintainers(patchedCar.getMaintainers());
            }
            carRepository.save(car);
            return true;
        }
        return false;
    }

    public boolean addCarMaintainer(Long carId, Long employeeId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalCar.isPresent() && optionalEmployee.isPresent()) {
            Car car = optionalCar.get();
            Employee employee = optionalEmployee.get();
            car.addMaintainer(employee);
            employee.addCarToMaintain(car);
            carRepository.save(car);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public List<Car> findCarsByTypeAndBrand(String type, String brand) {
        return carRepository.findByTypeAndBrand(type, brand);
    }

    public Set<Car> findCarsByMaintainer(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            Employee employee = employeeRepository.getReferenceById(employeeId);
            return employee.getCarsToMaintain();
        }
        return null;
    }
}
