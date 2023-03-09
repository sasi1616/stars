package com.Airline.Reservation.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Airline.Reservation.Model.AirlineReservation;
import com.Airline.Reservation.Service.AirlineService;

/*RestController annotation is used to create RESTful web services
 *RestController contains @Controller and @ResponseBody
 *@RestController is used to create controllers for REST APIs which can return JSON
 * @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON 
 * and passed back into the HttpResponse object*/

@RestController
public class AirlineControllers {
		public AirlineService royalServ;
		
		public AirlineControllers(AirlineService royalServ) {
			this.royalServ=royalServ;
		}
		@PostMapping("/saveFlightDetails")
		//json values converted into java object and it call sevice class save method and save details in royal object
		
		public ResponseEntity<AirlineReservation> saveRoyal(@RequestBody AirlineReservation royal){
			return new ResponseEntity<AirlineReservation>(royalServ.saveRoyal(royal), HttpStatus.CREATED);
		}
		@PutMapping("/updatRoyal/{flight_id}")
		//json values converted into java object and it call sevice class update method and @PAthvariable extract id and save details in royal object
		
		public ResponseEntity<AirlineReservation> updateFlightDetails(@PathVariable("flight_id") int flight_id,
				@RequestBody AirlineReservation royal){
			return new ResponseEntity<AirlineReservation>(royalServ.updateFlightDetails(royal, flight_id), HttpStatus.OK);

		}
		
		//display all details
		
		@GetMapping("/readAllDetails")
		public List<AirlineReservation> getAllFlightDetails(){
			return royalServ. getAirFromDb();// it calls the getAirFromDb it get all details by using pre-defined findAll method
		}
		
		//display the details of particular id
		@GetMapping("/readDetails/{id}")
		/*json values converted into java object and it call sevice class getAirlineReservationById method 
		 * and @PAthvariable extract id and save details in royal object*/
		
		public ResponseEntity<AirlineReservation>  getAirlineReservationById(@PathVariable("id")  int empId){
		
			return new ResponseEntity<AirlineReservation>(royalServ.getAirlineReservationById(empId), HttpStatus.OK);
		}

		@DeleteMapping("/deleteDetails/{id}")
		/*json values converted into java object and it call sevice class deleteflightdetailsById method 
		 * and @PAthvariable extract id and save details in royal object it return successfully deleted*/
		public ResponseEntity<String> deleteDetailsById(@PathVariable("id") int flight_id){
			royalServ.deleteFlightDetailsById(flight_id);
			return new ResponseEntity<String>(royalServ.deleteFlightDetailsById(flight_id),HttpStatus.OK);
		}



}
