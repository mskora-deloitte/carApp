package com.dolittle.carApp.dao;

import com.dolittle.carApp.model.Outpost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutpostRepository extends JpaRepository<Outpost, Long> {
}
