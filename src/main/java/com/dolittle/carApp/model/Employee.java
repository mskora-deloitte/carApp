package com.dolittle.carApp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    public enum Position {
        SALESMAN,
        MANAGER,
        ACCOUNTANT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Position position;
    private String name;
    private String surname;
    //    private Long outpostId;
    @ManyToOne
    private Outpost outpost;
    @ManyToMany
    private Set<Car> carsToMaintain;

    public Employee() {
    }

    public Employee(Position position, String name, String surname) {
        this.position = position;
        this.name = name;
        this.surname = surname;
    }

    public Employee(Position position, String name, String surname, Outpost outpost) {
        this.position = position;
        this.name = name;
        this.surname = surname;
        this.outpost = outpost;
    }

    public Employee(Position position, String name, String surname, Outpost outpost, Set<Car> carsToMaintain) {
        this.position = position;
        this.name = name;
        this.surname = surname;
        this.outpost = outpost;
        this.carsToMaintain = carsToMaintain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Outpost getOutpost() {
        return outpost;
    }

    public void setOutpost(Outpost outpost) {
        this.outpost = outpost;
    }

    public Set<Car> getCarsToMaintain() {
        return carsToMaintain;
    }

    public void setCarsToMaintain(Set<Car> carsToMaintain) {
        this.carsToMaintain = carsToMaintain;
    }

    public void addCarsToMaintain(Set<Car> carsToMaintain) {
        this.carsToMaintain.addAll(carsToMaintain);
    }

    public void addCarToMaintain(Car carToMaintain) {
        this.carsToMaintain.add(carToMaintain);
    }
}
