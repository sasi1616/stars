package com.Airline.Reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airline.Reservation.model.AirlineReservation;

public interface AirlineRepository extends JpaRepository<AirlineReservation,Long>{

}
