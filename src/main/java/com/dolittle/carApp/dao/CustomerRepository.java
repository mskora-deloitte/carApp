package com.dolittle.carApp.dao;

import com.dolittle.carApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
