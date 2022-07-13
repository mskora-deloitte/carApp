package com.dolittle.customer;

import com.dolittle.rental.Rental;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String birthDate;
    private String phoneNumber;
    private String creditCardNumber;
    private String name;
    private String surname;
    @OneToMany
    private Rental rental;
}
