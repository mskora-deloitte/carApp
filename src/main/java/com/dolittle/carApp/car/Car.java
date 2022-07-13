package com.dolittle.carApp.car;

import com.dolittle.carApp.employee.Employee;
import com.dolittle.carApp.rental.Rental;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<Rental> rentals = new HashSet<>();
    @ManyToMany
    private Set<Employee> maintainers = new HashSet<>();

    public Car() {

    }

    public Car(String type, String brand, Integer productionYear, String color, Float engineCapacity,
               Integer power, Integer mileage) {
        this.type = type;
        this.brand = brand;
        this.productionYear = productionYear;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.power = power;
        this.mileage = mileage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public void addRentals(Set<Rental> rentals) {
        this.rentals.addAll(rentals);
    }

    public void addRentals(Rental rental) {
        this.rentals.add(rental);
    }

    public Set<Employee> getMaintainers() {
        return maintainers;
    }

    public void setMaintainers(Set<Employee> maintainers) {
        this.maintainers = maintainers;
    }

    public void addMaintainers(Set<Employee> maintainers) {
        this.maintainers.addAll(maintainers);
    }

    public void addMaintainer(Employee maintainer) {
        this.maintainers.add(maintainer);
    }
}
