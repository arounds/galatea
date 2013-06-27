package model.person;

import model.*;
import model.document.*;
import model.entity.*;
import model.interviewingEvent.*;
import model.person.Person.PersonType;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import database.DatabaseManager;

/**
 * Creates Person objects and facilitates interaction between the Controller and the DatabaseManager.
 * 
 * @author 	rounds
 * @updated 2013-06-19 04:43 PM
 */
public class PersonFactory {

	//Attributes
	protected DatabaseManager databaseManager;
	protected PersonRowMapper personRowMapper;
	
	//Constructors
	public PersonFactory(){}
	
	public PersonFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}
	
	//Methods

	public Candidate createAndInsertCandidate(String firstName,
			String middleName, String lastName, String maidenName,
			String preferredName, PersonType type, String email, String phone,
			String streetAddress, String city, String state, String zip,
			String country, String status, RecruitingEvent recruitingEvent,
			Document resume) throws SQLException {
		
		Integer id = null;
		Calendar updateTime = null;
		Calendar insertTime = null;
		List<InterviewingEvent> interviewingEvents = null;
		
		//Create Candidate object
		Candidate candidate = new Candidate(
				id, 
				firstName, 
				middleName, 
				lastName, 
				maidenName, 
				preferredName, 
				updateTime, 
				insertTime, 
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
				interviewingEvents,
				resume);
		
		//Insert candidate 
		ResultSet rs_person = insertPerson(candidate);
		
		//Analyze ResultSet
		Person dbPerson = personRowMapper.mapRow(rs_person, 1);
		
		//Update candidate with new info
		candidate.setId(dbPerson.getId());
		candidate.setUpdateTime(dbPerson.getUpdateTime());
		candidate.setInsertTime(dbPerson.getInsertTime());
		
		return candidate;
	}
/**
 * Prepares the CallableStatement, calls it and returns the result set.
 * @param person
 * @return
 */
	protected ResultSet insertPerson(Person person) throws SQLException {
		
		CallableStatement stmt = prepareCall_insertPerson(person);
		ResultSet rs_person = databaseManager.callStatement(stmt);
		
		return rs_person;
	}

	protected CallableStatement prepareCall_insertPerson(Person person) throws SQLException {
		CallableStatement stmt = databaseManager.connection.prepareCall("{CALL insertPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		stmt.setString("inputFirstName", person.getFirstName());
		stmt.setString("inputMiddleName", person.getMiddleName());
		stmt.setString("inputLastName", person.getLastName());
		stmt.setString("inputMaidenName", person.getMaidenName());
		stmt.setString("inputPreferredName", person.getPreferredName());
		stmt.setString("inputType", person.getType().toString());
		stmt.setString("inputEmail", person.getEmail());
		stmt.setString("inputPhone", person.getPhone());
		stmt.setString("inputStreetAddress", person.getStreetAddress());
		stmt.setString("inputCity", person.getCity());
		stmt.setString("inputState", person.getState());
		stmt.setString("inputZip", person.getZip());
		stmt.setString("inputCountry", person.getCountry());
		stmt.setInt("inputDocument_id", person.getDocument_id());
		stmt.setInt("inputRecruitingEvent_id", person.getRecruitingEvent_id());
		stmt.setString("inputStatus", person.getStatus());
	
		return stmt;
	}









}
