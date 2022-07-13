package com.dolittle.carApp.repository;

import com.dolittle.carApp.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
