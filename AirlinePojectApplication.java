package com.Airline.Reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@SpringBootApplication is the combination of three annotations of @ComponentScan, @EnableAutoConfiguration, and @springbootConfiguration
 * @ComponentScan used to scan current package and itscan all sub packages
 * @EnableAutoConfiguration annotation enables Spring Boot to auto-configure the application context. T
 * it automatically creates and registers beans
 * @SpringBootConfiguration annotation manage the configuration file.
 * */
@SpringBootApplication
public class AirlinePojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinePojectApplication.class, args);
	}

}
