package com.dolittle.carApp.dao;

import com.dolittle.carApp.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
