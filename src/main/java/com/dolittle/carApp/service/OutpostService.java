package com.dolittle.carApp.service;

import com.dolittle.carApp.dao.CarRepository;
import com.dolittle.carApp.dao.EmployeeRepository;
import com.dolittle.carApp.dao.OutpostRepository;
import com.dolittle.carApp.model.Employee;
import com.dolittle.carApp.model.Outpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OutpostService {

    @Autowired
    private OutpostRepository outpostRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarRepository carRepository;

    public Outpost addOutpost(Outpost outpost) {
        return outpostRepository.save(outpost);
    }

    public boolean deleteOutpost(Long id) {
        if (!outpostRepository.existsById(id)) {
            return false;
        }
        employeeRepository.findAll().stream()
                .filter(employee -> employee.getOutpost().getId().equals(id))
                .forEach(employee -> employee.setOutpost(null));
        outpostRepository.deleteById(id);
        return true;
    }

    public boolean patchOutpost(Outpost patchedOutpost) {
        if (!outpostRepository.existsById(patchedOutpost.getId())) {
            return false;
        }
        Outpost outpost = outpostRepository.getReferenceById(patchedOutpost.getId());
        if (patchedOutpost.getAddress() != null) {
            outpost.setAddress(patchedOutpost.getAddress());
        }
        if (patchedOutpost.getPhoneNumber() != null) {
            outpost.setPhoneNumber(patchedOutpost.getPhoneNumber());
        }
        outpostRepository.save(outpost);
        return true;
    }

    public boolean addEmployeeToOutpost(Long outpostId, Long employeeId) {
        if (!outpostRepository.existsById(outpostId) || !employeeRepository.existsById(employeeId)) {
            return false;
        }
        Outpost outpost = outpostRepository.getReferenceById(outpostId);
        Employee employee = employeeRepository.getReferenceById(employeeId);
        employee.setOutpost(outpost);
        employeeRepository.save(employee);
        return true;
    }

    public Set<Employee> getOutpostEmployees(Long outpostId) {
        if (!outpostRepository.existsById(outpostId)) {
            return null;
        }
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getOutpost().getId().equals(outpostId))
                .collect(Collectors.toSet());
    }

    public Set<Employee> getOutpostCarMaintainers(Long outpostId, Long carId) {
        if (!outpostRepository.existsById(outpostId) || !carRepository.existsById(carId)) {
            return null;
        }
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getOutpost().getId().equals(outpostId))
                .filter(employee -> employee.getCarsToMaintain().contains(carRepository.getReferenceById(carId)))
                .collect(Collectors.toSet());
    }
}
