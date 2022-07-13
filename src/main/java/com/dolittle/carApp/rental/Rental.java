package com.dolittle.carApp.rental;

import com.dolittle.carApp.car.Car;
import com.dolittle.carApp.outpost.Outpost;
import com.dolittle.carApp.customer.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate rentalDate;
    private BigDecimal price;
    @ManyToOne
    private Outpost rentOutpost;
    @ManyToOne
    private Outpost returnOutpost;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;

    public Rental(LocalDate rentalDate, BigDecimal price, Outpost rentOutpost, Outpost returnOutpost,
                  Car car, Customer customer) {
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

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
