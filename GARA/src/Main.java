

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
	
	public static void main(String[] args) {
		ApplicationController applicationController = new ApplicationController();
		applicationController.start();
		
		String command = "createCandidate";
		String[] arguments = new String[100];
		
		arguments[0] = "firstName";
		arguments[1] = "middleName";
		arguments[2] = "lastName";
		arguments[3] = "maidenName";
		arguments[4] = "preferredName";
		arguments[5] = "email";
		arguments[6] = "phone";
		arguments[7] = "streetAddress";
		arguments[8] = "city";
		arguments[9] = "state";
		arguments[10] = "zip";
		arguments[11] = "country";
		arguments[12] = "status";

		
		if (command.equals("createCandidate")){
			PersonResponse response = applicationController.manageCreateNewCandidate(false, arguments[1], arguments[2], arguments[3], arguments[4], arguments[5], PersonType.CANDIDATE, arguments[6], arguments[7], arguments[8], arguments[9], arguments[10], arguments[11], arguments[12], arguments[13], null, null);
			List<? extends Person> people = response.getPeople();
			System.out.println(people.get(0).toString());
		}
		else if (command.equals("help")){
			System.out.printf("Help Menu!");
		}
	

	}
	

}
