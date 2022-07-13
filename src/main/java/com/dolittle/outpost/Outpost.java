package com.dolittle.outpost;

import com.dolittle.employee.Employee;
import com.dolittle.rental.Rental;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Outpost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private String address;
    @OneToMany
    private Set<Employee> employees = new HashSet<>();
    @OneToMany
    private List<Rental> rentals = new ArrayList<>();
    @OneToMany
    private List<Rental> returns = new ArrayList<>();

    public Outpost(Long id, String phoneNumber, String address) {
        super();
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployees(Set<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void addRentals(List<Rental> rentals) {
        this.rentals.addAll(rentals);
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public List<Rental> getReturns() {
        return returns;
    }

    public void setReturns(List<Rental> returns) {
        this.returns = returns;
    }

    public void addReturns(List<Rental> returns) {
        this.returns.addAll(returns);
    }

    public void addReturn(Rental returned) {
        this.returns.add(returned);
    }
}
