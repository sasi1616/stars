package DataBase;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;
public class DriverClass {
	static Scanner scanobj=new Scanner(System.in);
	static Connection connection =null;

	public static Connection establishConnection() {
		// this method create connection to mysql

		try {
			String userName = "root";
			String password = "Isas@1234";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline_Reservation", userName, password);

		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		return connection;
	}

	public static void main(String[] args) throws NullPointerException,SQLException{
		
		DataBaseSql object=new DataBaseSql();

		Connection connectionToDataBase= establishConnection();// method call
		RoyalAirlines flight_object=new RoyalAirlines();
		flight_object.login();								//calling login method 
		System.out.println("Press 1 to add an airline");

		System.out.println("Press 2 to display all the airlines");

		System.out.println("Press 3 to search an airline");

		System.out.println("Press 4 to delete an  airline");

		System.out.println("Press 5 to update an airline");

		System.out.println("Press 6 to logout");
		byte input;
		do {
			input=scanobj.nextByte();  //getting choice from user
			switch(input) {
			case 1:
				object.add(connectionToDataBase); // add method called
				break;
			case 2:
				object.display(connectionToDataBase);  //display method called
				break;
			case 3:
				object.search(connectionToDataBase);  //search method called
				break;
			case 4:
				object.delete(connectionToDataBase);  //search method called
				break;
			case 5:
				object.update(connectionToDataBase);  //update method called
				break;
			case 6:
				System.out.println("LoggedOut successfully");
				connection.close();						//connection is closed so program will be stoped
				scanobj.close();
				break;
			}
		}
		while(input!=6);



	}

}

