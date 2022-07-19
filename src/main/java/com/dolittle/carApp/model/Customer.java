package com.dolittle.carApp.model;

import com.dolittle.carApp.model.Rental;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private LocalDate birthDate;
    private String phoneNumber;
    private String creditCardNumber;
    private String name;
    private String surname;
    @OneToMany
    private Set<Rental> rentals;

    public Customer() {
    }

    public Customer(String address, LocalDate birthDate, String phoneNumber, String creditCardNumber,
                    String name, String surname) {
        this.address = address;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
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
}
