package model.interviewingEvent;

import java.util.List;

import com.google.cloud.sql.jdbc.ResultSet;

import database.DatabaseManager;


public class InterviewingEventAndEvalFactory {
	
	//Attributes
		protected DatabaseManager databaseManager;
		
	//Constructors
	public InterviewingEventAndEvalFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}

	//Methods
	public ResultSet callInsertEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet callSelectEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet callUpdateEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public InterviewingEvent createNewEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<InterviewingEvent> getCandidatesInterviewingEvents(
			Integer person_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<InterviewingEvent> getEmployeesInterviewingEvents(
			Integer person_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public InterviewingEvent getExistingEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	public InterviewingEvent updateExistingEvent() {
		// TODO Auto-generated method stub
		return null;
	}

}
