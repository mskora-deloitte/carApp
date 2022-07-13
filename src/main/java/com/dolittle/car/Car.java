package com.dolittle.car;

import com.dolittle.employee.Employee;
import com.dolittle.rental.Rental;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String brand;
    private Integer productionYear;
    private String color;
    private Float engineCapacity;
    private Integer power;
    private Integer mileage;
    @OneToMany
    private Rental rental;
    @ManyToMany
    private Set<Employee> maintainers;
}
