

import java.sql.SQLException;
import java.util.List;

import model.person.Person;
import model.person.Person.PersonType;

import controller.ApplicationController;
import controller.PersonResponse;


/**
 * Initializes the application controller and starts the application.
 * 
 * @author 	rounds
 * @updated	2013-06-19 12:20 PM		
 */
public class Main {
	
	public static void main(String[] args) throws SQLException {
		ApplicationController applicationController = new ApplicationController();
		applicationController.start();
		
		testingDatabase(applicationController);
		
		String command = "createCandidate";
		String[] arguments = new String[100];
		
		arguments[1] = "Joe";
		arguments[2] = "TheMan";
		arguments[3] = "Schmoe";
		arguments[4] = null;
		arguments[5] = "Joey";
		arguments[6] = "jschmoe@gmail.com";
		arguments[7] = "555.555.5555";
		arguments[8] = "21 Awesome Way";
		arguments[9] = "Medford";
		arguments[10] = "MA";
		arguments[11] = "02155";
		arguments[12] = "USA";
		arguments[13] = "ACTIVE";

		
		if (command.equals("createCandidate")){
			PersonResponse response = applicationController.manageCreateNewCandidate(false, arguments[1], arguments[2], arguments[3], arguments[4], arguments[5], PersonType.CANDIDATE, arguments[6], arguments[7], arguments[8], arguments[9], arguments[10], arguments[11], arguments[12], arguments[13], null, null);
			List<? extends Person> people = response.getPeople();
			System.out.println(people.get(0).toString());
		}
		else if (command.equals("help")){
			System.out.printf("Help Menu!");
		}
	

	}
	
	private static void testingDatabase(ApplicationController applicationController){
		String response = "unsuccessful";
		try {
			response = applicationController.testDatabase();
		} catch (SQLException e) {
			System.out.println("Something happened");
			e.printStackTrace();
		}
		System.out.println("FirstName should be Anika. It is: "+response);
	}
	

}
