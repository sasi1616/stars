package com.Airline.Reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@SpringBootApplication is the combination of three annotations of @ComponentScan, @EnableAutoConfiguration, and @Configuration
 * @ComponentScan used to scan current package and itscan all sub packages
 * @EnableAutoConfiguration annotation enables Spring Boot to auto-configure the application context. T
 * it automatically creates and registers beans
 * @Configuration annotation which indicates that the class has @Bean definition methods.
 * */
@SpringBootApplication
public class FullStackProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackProjectApplication.class, args);
		System.out.println("server started..");
	}

}
