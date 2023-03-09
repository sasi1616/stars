package com.Airline.Reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airline.Reservation.Model.AirlineReservation;
//AirlineRepository interface extends jpa repository to use hibernate methods
public interface AirlineRepository extends JpaRepository<AirlineReservation,Integer> {

}
