import java.util.Calendar;
import java.util.List;


public class ApplicationController {
	/**
	 * Facilitates the interaction between the View and Model.
	 * 
	 * @author  rounds
	 * @updated	2013-06-19 01:58 PM	
	 */
	
	//Variables
	protected ConsoleView consoleView;
	protected DatabaseManager databaseManager;
	
	protected DocumentFactory documentFactory;
	protected EntityFactory entityFactory;
	protected InterviewingEventAndEvalFactory interviewingEventFactory;
	protected PersonFactory personFactory;
	protected RecruitingEventFactory recruitingEventFactory;
	protected SchedulingEntryFactory schedulingEntryFactory;
	
	//Constructors
	public ApplicationController(){
		consoleView = new ConsoleView();
		databaseManager = new DatabaseManager();
		documentFactory = new DocumentFactory(databaseManager);
		entityFactory = new EntityFactory(databaseManager);
		interviewingEventFactory = new InterviewingEventAndEvalFactory(databaseManager);
		personFactory = new PersonFactory(databaseManager);
		recruitingEventFactory = new RecruitingEventFactory(databaseManager);
		schedulingEntryFactory = new SchedulingEntryFactory(databaseManager);
	}

	//Methods

	public void start() {
		/**
		 * Performs all the necessary tasks to start the application.
		 * Should only be performed once per application.
		 * <p>
		 * First registers the driver manager, gets the connection for the databaseManager, 
		 * then initializes the view. 
		 * Then it tells the view to display the appropriate home screen. 
		 * 
		 * @author  rounds
		 * @updated	2013-06-19 12:20 PM	
		 * 
		 */
		
	}


	public void quit() {
		// TODO Auto-generated method stub
		
	}

	//Person Methods
	
	public Person createNewPerson(String firstName, 
			String middleName, String lastName, 
			String maidenName, String preferredName, 
			String personType, String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, 
			String status, RecruitingEvent rEvent, Document doc){
		
		/**
		 * Creates a new Person object and inserts into the database.
		 * This method first assesses if the person is already in the database 
		 * based on the first and last names. It will then prompt the user if a person
		 * does exist in the database
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 12:20 PM
		 * 
		 * @param 	person 		a Person 
		 * @param	exists		a boolean assessing a person's existence
		 * @param	action		an integer assessing whether to create a new person, update an existing, get an existing person or do neither
		 * @param	rEvent_id	an integer representing the database id of the person's recruiting event
		 * @param 	doc_id		an integer representing the database id of the person's resume/contract
		 * @param 	updateTime	a Calendar holding the time the person's database entry was updated
		 * @return	person
		 */
		
		//Begin
		
		Person person = personFactory.createPersonObject(firstName, middleName, lastName, maidenName, preferredName, 
				personType, email, phone, streetAddress, city, state, zipCode, country, status, rEvent, doc);
		
		Boolean exists = personFactory.checkIfPersonExists(person.firstName, person.lastName);
		Integer action = 1; //The default is to create the person
		
		if (exists){
			action = doesUserWantToCreateUpdateOrGetPerson();
		}
		switch (action){
		case 0: //Don't create a new person, and don't update existing
			return null;
		case 1: //Create a new person
			break;
		case 2: //Update the existing person
			person = updateExistingPerson(person.firstName, person.lastName, 
					firstName, middleName, lastName, maidenName, preferredName, 
					personType, email, phone, streetAddress, city, state, zipCode, country, 
					status, rEvent, doc); 
			break;
		case 3: //Get the existing person
			person = getExistingPerson(firstName, lastName);
			break;
		}
		Integer rEvent_id = recruitingEventFactory.getRecruitingEventId(rEvent);
		Integer doc_id = documentFactory.getDocumentId(doc);
		Calendar updateTime = personFactory.insertPerson(person, personType, rEvent_id, doc_id);
		person.setUpdateTime(updateTime);
		
		return person;
	}

	public Person updateExistingPerson(String currentFirstName, String currentLastName, String firstName,
			String middleName, String lastName, String maidenName,
			String preferredName, String personType, String email,
			String phone, String streetAddress, String city, String state,
			String zipCode, String country, String status,
			RecruitingEvent rEvent, Document doc) {
		/**
		 * Updates an existing person's information.
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param 	person 		a updated Person
		 * @param 	person_id	an integer representing the database id of the person
		 * @param	exists		a boolean assessing a person's existence
		 * @param	action		an integer assessing whether to create a new person, update an existing, get an existing person or do neither
		 * @param	rEvent_id	an integer representing the database id of the person's recruiting event
		 * @param 	doc_id		an integer representing the database id of the person's resume/contract
		 * @param 	updateTime	a Calendar holding the time the person's database entry was updated
		 * @return	person
		 */
		
		Person person = personFactory.createPersonObject(firstName, middleName, lastName, maidenName, preferredName, 
				personType, email, phone, streetAddress, city, state, zipCode, country, status, rEvent, doc);
		Integer person_id = null;
		
		Boolean exists = personFactory.checkIfPersonExists(currentFirstName, currentLastName);
		Integer action = 2; //The default is to update the person
		
		if (exists){
			List<Integer> possiblePerson_ids = personFactory.getPersonId(person.firstName, person.lastName);
			person_id = determineCorrectPerson(possiblePerson_ids);
		}
		if (!exists){
			action = doesUserWantToCreateUpdateOrGetPerson();
		}
		switch (action){
		case 0: //Don't create a new person, and don't update existing
			return null;
		case 1: //Create a new person
			person = createNewPerson(firstName, middleName, lastName, maidenName, preferredName, 
				personType, email, phone, streetAddress, city, state, zipCode, country, status, rEvent, doc);
			break;
		case 2: //Update the existing person 
			break;
		case 3: //Get the existing person
			//This action will never occur in this method.
			return null;
		}
		Integer rEvent_id = recruitingEventFactory.getRecruitingEventId(rEvent);
		Integer doc_id = documentFactory.getDocumentId(doc);
		Calendar updateTime = personFactory.updatePerson(person_id, person, personType, rEvent_id, doc_id);
		person.setUpdateTime(updateTime);

		return person;
	}
	
	private Integer determineCorrectPerson(List<Integer> possiblePerson_ids) {
		/**
		 * Determines the unique person a user intends to access.
		 * Given a list of person_id's, this method gathers information on each 
		 * of these people and then asks the user which unique person they would like to access. 
		 * Returns the id of that person.
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:32 PM
		 * 
		 * @param 	person 		a Person 
		 * @return	person_id
		 */
		
		// TODO Auto-generated method stub
		return null;
	}

	public Person getExistingPerson(String firstName, String lastName) {
		/**
		 * Gets an existing person from the database.
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 12:20 PM
		 * 
		 * @param 	person 		a Person 
		 * @param	exists		a boolean assessing a person's existence
		 * @param	action		an integer assessing whether to create a new person, update an existing, get an existing person or do neither
		 * @param	rEvent_id	an integer representing the database id of the person's recruiting event
		 * @param 	doc_id		an integer representing the database id of the person's resume/contract
		 * @param 	updateTime	a Calendar holding the time the person's database entry was updated
		 * @return	person
		 */
		
		Boolean exists = personFactory.checkIfPersonExists(firstName, lastName);
		Integer action = 3; //The default is to get the person
		Integer person_id = null;
		
		if (exists){
			List<Integer> possiblePerson_ids = (List<Integer>) personFactory.getPersonId(firstName, lastName);
			person_id = determineCorrectPerson(possiblePerson_ids);
		}
		if (!exists){
			action = doesUserWantToCreateUpdateOrGetPerson();
		}
		switch (action){
		case 0: //Do nothing. Exit.
			return null;
		case 1: //Create a new person
			//Display the form to get the information for creating a new person
			break;
		case 2: //Update the existing person 
			//this action will never occur in this method.
			return null;
		case 3: //Get the existing person
			break;
		}
		
		Person person = personFactory.getPerson(person_id);
		
		return person;
	}

	public Integer doesUserWantToCreateUpdateOrGetPerson() {
		/**
		 * Asks user if they want to create, update, or get a person.
		 * This is implemented when either
		 * 		createNewPerson is called and the person may already exist,
		 *  	updateExistingPerson is called and the person does not exist, or
		 *  	getExistingPerson is called and the person does not exist.
		 * It returns 
		 * 		0, when a user wishes to return to the menu,
		 * 		1, when a user wishes to create a new person,
		 * 		2, when a user wishes to update an existing person, or
		 * 		3, when a user wishes to get an existing person.
		 *
		 * @author 	rounds
		 * @date 	2013-06-19 12:20 PM
		 */
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
