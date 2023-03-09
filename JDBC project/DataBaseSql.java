package DataBase;
import java.sql.*;
import java.util.Scanner;

public class DataBaseSql {
	static final Scanner scan=new Scanner(System.in);
	
	public void add(Connection connection)throws SQLException{
		//prepare statement used for get details from user
		PreparedStatement add_details = connection.prepareStatement("INSERT INTO Airline VALUES(?,?,?,?,?,?)");
		System.out.println("Enter flight ID:");
		add_details.setString(1, scan.next());
		System.out.println("Enter flight name:");
		add_details.setString(2, scan.next());
		System.out.println("Enter source_point:");
		add_details.setString(3, scan.next());
		System.out.println("Enter destination_point:");
		add_details.setString(4, scan.next());
		System.out.println("Enter Seating_capacity:");
		add_details.setInt(5, scan.nextInt());
		System.out.println("Enter cost:");
		add_details.setInt(6, scan.nextInt());
		int insert=add_details.executeUpdate();
		System.out.println(insert+"details are inserted");
	}
	public void display(Connection connection)throws SQLException {
		//
		Statement allDetails=connection.createStatement();
		//ResultSet interface used for retrieving records by creating resultset object.
		ResultSet resultset=allDetails.executeQuery("SELECT * FROM Airline ");//it get all details from Airline table
		while(resultset.next()) {//this loop run it get all details
			System.out.println(resultset.getString(1)+" "+resultset.getString(2)+" "+resultset.getString(3)+" "+resultset.getString(4)+resultset.getInt(5)+" "+resultset.getInt(6));
		}
	}
	//search particular details
	public void search(Connection connection) throws SQLException {
		//PreparedStatement interface is a sub interface of Statement. It is used to execute parameterized query.
		PreparedStatement searchId = connection.prepareStatement("SELECT * FROM Airline WHERE  Airline_id = ?");
		System.out.println("Enter flight ID:");
		String search_flightId=scan.next();
		searchId.setString(1,search_flightId);  
		ResultSet search_details=searchId.executeQuery(); //execute the query from corresponding statement and stored in resultset object 
		while(search_details.next()){  // get the records from result object
			System.out.println(search_details.getString(1)+" "+search_details.getString(2)+" "+search_details.getString(3)+" "+search_details.getString(4)+search_details.getInt(5)+" "+search_details.getInt(6));
		}
	}
	
	//delete particular flight details
	public	void delete(Connection connection) throws SQLException{
		PreparedStatement delete_object = connection.prepareStatement("DELETE FROM Airline WHERE  Airline_id = ?");
		System.out.println("Enter flight ID:");
		String delete_flightDetails=scan.next();
		delete_object.setString(1,delete_flightDetails);
		int delete_details=delete_object.executeUpdate();
		System.out.println(delete_details);

	}
	//update filght details
	public void update(Connection connection) throws SQLException{
		PreparedStatement update_details = connection.prepareStatement("UPDATE Airline set cost=? WHERE Airline_id=?");
		System.out.println("Enter flight ID:");
		update_details.setString(2, scan.next());
		System.out.println("Enter the cost to update: ");
		update_details.setInt(1, scan.nextInt());
		int updateFlightDetails=update_details.executeUpdate();
		System.out.println(updateFlightDetails+" values updated");
	}
}


