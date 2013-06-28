package controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import database.DatabaseManager;
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
		databaseManager = new DatabaseManager();
		documentFactory = new DocumentFactory(databaseManager);
		entityFactory = new EntityFactory(databaseManager);
		interviewingEventFactory = new InterviewingEventAndEvalFactory(databaseManager);
		personFactory = new PersonFactory(databaseManager);
		recruitingEventFactory = new RecruitingEventFactory(databaseManager);
		schedulingEntryFactory = new SchedulingEntryFactory(databaseManager);
	}
	
	public void setViewController(ViewController viewController){
		this.viewController = viewController;
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
		Boolean userOverride = null;
		do{
		userOverride = userOverrideIfPersonExists(firstName, lastName);  //if person exists, user must decide whether to create the person or not
		} while (userOverride==null);
		
		if (! userOverride){ //if the user does NOT want to create the candidate anyway
			return null;
		}
		
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

	private Boolean userOverrideIfPersonExists(String firstName, String lastName) {
		Boolean exists = personFactory.doesPersonExist(firstName, lastName);
		Boolean action = true;
		if (exists){
			action = viewController.doesUserWantToCreateNewPerson();
		}
		
		return action;
		
	}

	public void start() {
		//register driverManager
		
		//print initial greeting
		
		//create commandline stuffs
		
	}
	
	

}


	

