package controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import database.DatabaseManager;
import database.MockManager;
import model.*;
import model.document.*;
import model.entity.*;
import model.person.*;
import model.person.Person.PersonType;
import model.interviewingEvent.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;
import view.*;


/**
 * Facilitates the interaction between the View and Model.
 * 
 * @author  rounds
 * @updated	2013-06-19 01:58 PM	
 */
public class ApplicationController {

	//Variables
	protected ViewController viewController;
	protected DatabaseManager databaseManager;
	protected DocumentFactory documentFactory;
	protected EntityFactory entityFactory;
	protected InterviewingEventAndEvalFactory interviewingEventFactory;
	protected PersonFactory personFactory;
	protected RecruitingEventFactory recruitingEventFactory;
	protected SchedulingEntryFactory schedulingEntryFactory;
	
	//Constructors
	public ApplicationController(){
		viewController = new ViewController();
		databaseManager = new DatabaseManager();
		documentFactory = new DocumentFactory(databaseManager);
		entityFactory = new EntityFactory(databaseManager);
		interviewingEventFactory = new InterviewingEventAndEvalFactory(databaseManager);
		personFactory = new PersonFactory(databaseManager);
		recruitingEventFactory = new RecruitingEventFactory(databaseManager);
		schedulingEntryFactory = new SchedulingEntryFactory(databaseManager);
	}

//Methods
	/*-------------------------------------------------------------------------------------------------------------------------*/	
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
	public void start() {
		}
	
	public Candidate manageCreateNewCandidate(
			String firstName, 
			String middleName, 
			String lastName, 
			String maidenName,
			String preferredName, 
			Calendar updateTime, 
			Calendar insertTime, 
			PersonType type, 
			String email,
			String phone, 
			String streetAddress, 
			String city,
			String state, 
			String zip, 
			String country,
			String status,
			RecruitingEvent recruitingEvent,
			Document resume){
		//Check if candidate exists
		
		
		//Call PersonFactory to create and insert
		Candidate candidate = null;
		try {
			candidate = personFactory.createAndInsertCandidate(
					firstName, 
					middleName, 
					lastName, 
					maidenName, 
					preferredName, 
					type, 
					email, 
					phone, 
					streetAddress, 
					city, 
					state, 
					zip, 
					country, 
					status, 
					recruitingEvent, 
					resume);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return candidate;
		
		
	}





}


	

