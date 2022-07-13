package com.dolittle.carApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class CarAppApplication {
	public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
	}

}
