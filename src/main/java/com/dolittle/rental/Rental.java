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

    public Rental(Long id, String rentalDate, Long price, Outpost rentOutpost, Outpost returnOutpost,
                  Car car, Customer customer) {
        super();
        this.id = id;
        this.rentalDate = rentalDate;
        this.price = price;
        this.rentOutpost = rentOutpost;
        this.returnOutpost = returnOutpost;
        this.car = car;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Outpost getRentOutpost() {
        return rentOutpost;
    }

    public void setRentOutpost(Outpost rentOutpost) {
        this.rentOutpost = rentOutpost;
    }

    public Outpost getReturnOutpost() {
        return returnOutpost;
    }

    public void setReturnOutpost(Outpost returnOutpost) {
        this.returnOutpost = returnOutpost;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
