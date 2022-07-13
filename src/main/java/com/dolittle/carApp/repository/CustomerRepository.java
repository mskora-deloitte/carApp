package com.dolittle.carApp.repository;

import com.dolittle.carApp.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
