package com.dolittle.carApp.repository;

import com.dolittle.carApp.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
