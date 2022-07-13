package com.dolittle.carApp.repository;

import com.dolittle.carApp.outpost.Outpost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutpostRepository extends JpaRepository<Outpost, Long> {
}
