package hibernate.project1;


import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class App 
{
	private static Scanner scan = new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    		try {
    			
    			/*Configuration is a class. It reads both configuration file and mapping files.*/
    			
    		Configuration config = new Configuration().configure("project1.cfg.xml").addAnnotatedClass(AirlineReservationSystem.class);
    		
    		/*SessionFactory is an Interface which is present in org.hibernate package and it is used to create Session Object.
    		 * buildSessionFactory() method gathers the data which is in the cfg Object. 
				From cfg object it takes the JDBC information and create a JDBC Connection.*/
    		
			SessionFactory sessionFact = config.buildSessionFactory(); 
			Session session = sessionFact.openSession();
			AirlineReservationSystem airlineobject = new AirlineReservationSystem();
			airlineobject.checkingcredentials();  //method call
			
			byte adminChoice ;
			do 
			{
				adminChoice = scan.nextByte();

				switch(adminChoice) 
				{

				case 1:

					airlineobject.createAirline(session); //calls the createAirline method
					break;

				case 2:

					airlineobject.displayById(session);  //calls the display by id  method to display the details
					break;

				case 3:

					airlineobject.deleteById(session);  //calls the delete by id  method to delete the details
					break;

				case 4:

					airlineobject.updateById(session);  //calls the update by id  method to update the details
					break;

				case 5:

					airlineobject.toLogOut();   //calls tologout method to left
					break;

				}
			}
			while (adminChoice != 5) ;
			scan.close();
		}
		catch(HibernateException obj) 
		{

		}
		catch(Exception obj) 
		{

		}
	}	

    		

    }

