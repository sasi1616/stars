package DataBase;
import java.util.Scanner;
public class RoyalAirlines {
	
	private String flight_name,source,destination;
	private String flight_id;
	private int noOfseats,cost;
	private static Scanner scan=new Scanner(System.in);
	//creating getters and setters to access private attribute
	public  String getFlightId() {
		return flight_id;
	}
	public void setFlightId(String  flight_id) {
		this.flight_id=flight_id;
	}

	public  String getFlightName(String flight_name) {
		return flight_name;
	}
	public void setFlightName(String  flight_name) {
		this.flight_name=flight_name;
	}

	public  String getSource() {
		return source;
	}
	public void setSource(String  source) {
		this.source=source;
	}

	public  String getDestination() {
		return destination;
	}
	public void setDestination(String  destination) {
		this.destination=destination;
	}

	public  int getSeatingCapacity() {
		return noOfseats;
	}
	public void setSeatingCapacity(int noOfseats) {
		this.noOfseats= noOfseats;
	}

	public  int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost=cost;
	}
	
	//if username and password is not correct this method is called
	public void recheck(String user_name,String user_passWord) {
		
		RoyalAirlines flight_object=new RoyalAirlines();


		flight_object.login();
	}
	
	//it check username and password is correct or not. if password and username is not correct it calls recheck method
	public void login() {
		System.out.println();
		System.out.println("Enter UserName: ");
		String user_name=scan.next();
		System.out.println("Enter UserPassWord: ");
		String user_passWord=scan.next();
		if(user_name.equals("Royal$$") && user_passWord.equals("Isas@123" )) {
			System.out.println();
			System.out.println(".........SUCCESSFULLY LOGGED IN.........");
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("check your credentials");
			recheck(user_name,user_passWord);
		}


	}


}
