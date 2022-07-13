package com.dolittle.rental;

import com.dolittle.car.Car;
import com.dolittle.customer.Customer;
import com.dolittle.outpost.Outpost;

import javax.persistence.*;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rentalDate;
//    private Long customerId;
//    private Long carId;
//    private Long rentOutpostId;
//    private Long returnOutpostId;
    private Long price;
    @ManyToOne
    private Outpost rentOutpost;
    @ManyToOne
    private Outpost returnOutpost;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;
}
