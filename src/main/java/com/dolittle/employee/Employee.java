package com.dolittle.employee;

import com.dolittle.car.Car;
import com.dolittle.outpost.Outpost;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    enum Position {
        SALESMAN,
        MANAGER,
        ACCOUNTANT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Position position;
    private String name;
    private String surname;
//    private Long outpostId;
    @ManyToOne
    private Outpost outpost;
    @ManyToMany
    private Set<Car> carsToMaintain;
}
