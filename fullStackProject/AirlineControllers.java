package com.Airline.Reservation.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Airline.Reservation.ExceptionHandling.ResourceNotFoundException;
import com.Airline.Reservation.Repository.AirlineRepository;
import com.Airline.Reservation.model.AirlineReservation;
@CrossOrigin(origins = "http://localhost:4200")
/*RestController annotation is used to create RESTful web services
 *RestController contains @Controller and @ResponseBody
 *@RestController is used to create controllers for REST APIs which can return JSON
 * @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON 
 * and passed back into the HttpResponse object*/
@RestController
@RequestMapping("/ARS/")//it used to map the web request on to class and create base URL
public class AirlineControllers {
	
	@Autowired
	//@Autowired annotation is used for automatic dependency injection
	private AirlineRepository airlineRepository;
	
	// get all flightDetails
		@GetMapping("/flightDetails")
		public List<AirlineReservation> getAllAirlineDetails(){
			return airlineRepository.findAll(); //findAll is pre defined method in JPA repository class this method get all details from database
		}	
		
		// create flight rest api
		@PostMapping("/flightdetails")
		//@RequestBody used to convert httprequest into java object
		public AirlineReservation createAirlineReservation(@RequestBody AirlineReservation airline) {
			return airlineRepository.save(airline);//it saves all details in airline
		}
		
		// get flight details by id rest api
		@GetMapping("/ReadFlightdetails/{id}")
		//@PathVariable annotation is used to extract the value from the URI
		public ResponseEntity<AirlineReservation> getAirlineById(@PathVariable Long id) {
			AirlineReservation airline = airlineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("flight not exist with id :" + id));
			return ResponseEntity.ok(airline);
		}
		//update flight details by id
		@PutMapping("/updateFlightdetails/{id}")
		//@PathVariable annotation is used to extract the id from the URl
		public ResponseEntity<AirlineReservation> updateAirline(@PathVariable Long id, @RequestBody AirlineReservation flightDetails){
			/*extract the id from the URl by using @PathVariable
			 * if the given id exist it update details  otherwise it print flight not exist with id
			 * and it save the changes*/
			AirlineReservation airline_update = airlineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("flight not exist with id :" + id));
			
			airline_update.setSource(flightDetails.getSource());
			airline_update.setDestination(flightDetails.getDestination());
			airline_update.setCost(flightDetails.getCost());
			
			AirlineReservation updatedAirline = airlineRepository.save(airline_update);
			return ResponseEntity.ok(updatedAirline);
		}

		
		// delete employee rest api
		@DeleteMapping("/deleteFlightdetails/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAirline(@PathVariable Long id){
			/*extract the id from the URl by using @PathVariable
			 * if the given id exist it delete details and return true it print flight not exist with id*/
			AirlineReservation airline = airlineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("flight not exist with id :" + id));

			airlineRepository.delete(airline);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		

	
}
