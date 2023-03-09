package com.Airline.Reservation.AirlineServInterf;

import java.util.List;

import com.Airline.Reservation.Model.AirlineReservation;

/*this interface contains method declaration*/
public interface Airline {
	AirlineReservation saveRoyal(AirlineReservation royal);

	List<AirlineReservation> getAirFromDb();

	AirlineReservation getAirlineReservationById(int flight_id);

	AirlineReservation updateFlightDetails(AirlineReservation newVal, int flight_id);

	String deleteFlightDetailsById(int flight_id);

}
