package com.Airline.Reservation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Airline.Reservation.AirlineServInterf.Airline;
import com.Airline.Reservation.Model.AirlineReservation;
import com.Airline.Reservation.Repository.AirlineRepository;



//this class implements airline interface and it provides method definition for that method declaration
@Service
public class AirlineService implements Airline{
	
		AirlineRepository royalAirline;
	
		public AirlineService(AirlineRepository royalAirline) {
			this.royalAirline = royalAirline;
		}
		public AirlineReservation saveRoyal(AirlineReservation royal ) {
			return royalAirline.save(royal);//it save details
		}
		@Override
		public List<AirlineReservation> getAirFromDb() {
			return royalAirline.findAll();//findAll method used to get all details
		}
		@Override//5
		public AirlineReservation getAirlineReservationById(int flight_id) {
			/* opional class to use isPresent() method and if value is present inside the method 
			 * it returns particular details by use of findbyid method 
			 * else it return empty*/
			
			Optional<AirlineReservation> royal = royalAirline.findById(flight_id);
			if(royal.isPresent()) {
				return royal.get();
			}
			else {
				return null;
			}
		}
		@Override
		public AirlineReservation updateFlightDetails(AirlineReservation newVal, int flight_id) {
			/* opional class to use isPresent() method and if value is present 
			 * it returns updated values in existingRoyal object 
			 * else it return empty*/
			Optional<AirlineReservation> royal = royalAirline.findById(flight_id);
			if(royal.isPresent()) {
				AirlineReservation existingRoyal = royal.get();  

				existingRoyal.setCost(newVal.getCost());
				existingRoyal.setNoOfseats(newVal.getNoOfseats());
				existingRoyal.setSource(newVal.getSource());
				existingRoyal.setDestination(newVal.getDestination());
				royalAirline.save(existingRoyal);
				return existingRoyal;
			}
			else {
				return null;
			}
		}
		@Override
		public String deleteFlightDetailsById(int flight_id) {
			/* opional class to use isPresent() method and if value is present 
			 * it delete values and return deleted successfully
			 * else it return flight details not found*/
			Optional<AirlineReservation> royal = royalAirline.findById(flight_id);
			if(royal.isPresent()) {
				royalAirline.deleteById(flight_id);
				return "deleted successfully";
			}	
			else {
				return "flight details not found";
			}
		}

}
