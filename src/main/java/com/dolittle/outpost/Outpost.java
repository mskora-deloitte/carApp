package com.dolittle.outpost;

import com.dolittle.employee.Employee;
import com.dolittle.rental.Rental;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Outpost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private String address;
    @OneToMany
    private Set<Employee> employees = new HashSet<>();
    @OneToMany
    private List<Rental> rents = new ArrayList<>();
    @OneToMany
    private List<Rental> returns = new ArrayList<>();
}
