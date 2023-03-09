package hibernate.project1;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity  //it is class level annotation. it create table in database. name of the table is same as class name
@DynamicUpdate   //use dynamic update annotation to change particular values of the object 
public class AirlineReservationSystem {
	
	private static  Scanner scan = new Scanner(System.in);
	
	
	@Id		//Used for declaring a primary key 
	
	/*Hibernate automatically generate the values and we don’t need to set the values manually.
	 * generation type is identity(start by one and increment by one)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airline_Id;
	/*@column used to change the column name and contain size of the values and it cannot allows nullable values
	 * and unique means column values should be unique */
	@Column(name = "airline_name", length = 20, nullable = false)
	private String airline_Name;

	@Column(name = "airline_origin", unique = true)
	private String source;

	@Column(name = "destiny", unique = true)
	private String destination;

	private Integer seating_availability;

	private Integer cost;

	
	/*in login details method i passing the parameters. these parameters checked with pre defined username and password
	 * username and password are equal it print the below statement otherwise it print else statement */
	public  void loginDetails(String admin_name,String admin_password) 
	{
		if(admin_name.equals("Royal$$") && admin_password.equals("Isas@123" ))  
		{
			System.out.println("\nYOU HAVE SUCCESSFULLY LOGGED IN..");
			System.out.println("\n..........| WELCOME TO ROYAL AIRLINES |..........\n");
			//These statement are used to get the input from the user to perform the followings.
			System.out.println(" * ENTER 1 TO ADD AN AIRLINE   ");
			System.out.println(" * ENTER 2 TO SEARCH AN AIRLINE");
			System.out.println(" * ENTER 3 TO DELETE AN AIRLINE");
			System.out.println(" * ENTER 4 TO UPDATE AN AIRLINE");
			System.out.println(" * ENTER 5 TO LOGOUT           ");

		}
		else
		{
			System.out.println("\nPLEASE CHECK YOUR CREDENTIALS");
			checkingcredentials();
		}
	}
	public void checkingcredentials() {
		/*in this method i getting usernAme password from user to login*/
		System.out.print("\nENTER THE ADMIN NAME: ");
		String admin_name = scan.next();

		System.out.print("\nENTER THE ADMIN PASSWORD: ");
		String admin_password = scan.next();

		loginDetails(admin_name,admin_password);
	}
	public void toLogOut() {
		
		System.out.println("Logged out successfully.");

	}

	public void createAirline(Session session) {
		/*Transaction is used to give the instruction to the database to make the changes .*/
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		/*it calls getAirlineReservationSystem and get the inpt from user these details are permanently saved by commit()*/
		Integer id = (Integer) session.save(getAirlineReservationSystem());
		System.out.println("Airline is created with id :"+id);
		session.getTransaction().commit();

	}
	public AirlineReservationSystem getAirlineReservationSystem() {

		AirlineReservationSystem airline = new AirlineReservationSystem(); 
		
		/*creating object to store the details. 
		below statements are used to get details from user and stored in
		 airline object and return to create airline method*/

		System.out.println("ENTER THE AIRLINE_NAME:");
		String airline_Name = scan.next();
		airline.setAirline_Name(airline_Name);
		System.out.println("ENTER THE STARTINGPOINT:");
		String source = scan.next();
		airline.setSource(source);
		System.out.println("ENTER THE DESTINATION:");
		String destination = scan.next();
		airline.setDestination(destination);
		System.out.println("ENTER THE SEATING_CAPACITY:");
		Integer availability = scan.nextInt();
		airline.setSeating_availability(availability);
		System.out.println("ENTER THE COST:");
		Integer cost = scan.nextInt();
		airline.setCost(cost);

		return airline;

	}
	public void deleteById(Session session) { // in this method i deleting particular details
		System.out.println("Enter the Airline_id:");
		int airlineId = scan.nextInt();
		AirlineReservationSystem airline = session.get(AirlineReservationSystem.class,airlineId);

		if(airline != null) {   
			//to perform delete operation transaction should be started
			session.beginTransaction();  //get data from database
			session.remove(airline);     //it delete the details 
			session.getTransaction().commit(); //it save changes
			System.out.println("Airline Detail is deleted successfully. ");
		}
		else {
			System.out.println("Airline id does not exist");

		}	
	}
	public void updateById(Session session) {
		System.out.println("Enter the Airline_id:");
		int airlineId = scan.nextInt();

		AirlineReservationSystem airline = session.get(AirlineReservationSystem.class,airlineId);
		if(airline != null) {
			/* transaction begin for to update details and below statements are get details from user to update*/
			session.beginTransaction();
			System.out.println("ENTER THE STARTING POINT TO UPDATE :");
			String source = scan.next();
			airline.setSource(source);
			System.out.println("ENTER THE AIRLINE_DESTINATION TO UPDATE:");
			String destination = scan.next();
			airline.setDestination(destination);
			System.out.println("ENTER THE SEATING_CAPACITY TO UPDATE:");
			Integer availability = scan.nextInt();
			airline.setSeating_availability(availability);
			System.out.println("ENTER THE AIRLINE COST TO UPDATE:");
			Integer cost = scan.nextInt();
			airline.setCost(cost);
			session.persist(airline);
			session.getTransaction().commit();
			System.out.println("AIRLINE DETAILS ARE UPDATED ");
		}
		else {
			System.out.println("Airline id does not exist");

		}	
	}
	public void displayById(Session session){
		System.out.println("Enter the Airline_id:");
		int airlineId = scan.nextInt();// get id from user
		
		//get details from database and stored in created object
		AirlineReservationSystem airline = session.get(AirlineReservationSystem.class,airlineId);
		if(airline != null) {
			System.out.println(airline);  //it print the details of particular id
		}
		else {
			System.out.println("Airline id does not exist");

		}
	}

	/*getter and setters */
	public Integer getAirline_Id() {
		return airline_Id;
	}

	public void setAirline_Id(Integer airline_Id) {
		this.airline_Id = airline_Id;
	}

	public String getAirline_Name() {
		return airline_Name;
	}

	public void setAirline_Name(String airline_Name) {
		this.airline_Name = airline_Name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getSeating_availability() {
		return seating_availability;
	}

	public void setSeating_availability(Integer seating_availability) {
		this.seating_availability = seating_availability;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "AirlineReservationSystem [airline_Id=" + airline_Id + ", airline_Name=" + airline_Name + ", source="
				+ source + ", destination=" + destination + ", seating_availability=" + seating_availability + ", cost="
				+ cost + "]";
	}

	
	


}
