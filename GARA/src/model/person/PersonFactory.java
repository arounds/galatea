package model.person;

import model.document.*;
import model.person.Person.PersonType;
import model.recruitingEvent.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;

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

	public List<Person> createAndInsertNewPerson(String firstName,
			String middleName, String lastName, String maidenName,
			String preferredName, PersonType type, String email, String phone,
			String streetAddress, String city, String state, String zip,
			String country, String status, RecruitingEvent recruitingEvent,
			Document document) {
		List<Person> people = new ArrayList<Person>(1);
		
		Person person = insertPerson(firstName, middleName, 
				lastName, maidenName, preferredName, type, email, phone, 
				streetAddress, city, state, zip, country, 
				status, recruitingEvent, document);
		switch (type){
		case CANDIDATE: 
			Candidate candidate = newCandidate(person, recruitingEvent, document);
			people.add(candidate);
			break;
		case EMPLOYEE: 
			Employee employee = newEmployee(person, document);
			people.add(employee);
			break;
		case RECRUITER:
			Recruiter recruiter = newRecruiter(person);
			people.add(recruiter);
			break;
		}
		return people;
	}
/**
 * Prepares the CallableStatement, calls it and returns the result set.
 * @param person
 * @return
 */
	protected List<Person> insertPerson(Person person) throws SQLException {
		
		CallableStatement stmt = prepareCall_insertPerson(person);
		ResultSet rs_person = databaseManager.callStatement(stmt);
		List<Person> newPerson = new ArrayList<Person>(1);
		for(int i=1; rs_person.next(); i++){
			Person nextPerson = personRowMapper.mapRow(rs_person, i);
			newPerson.add(nextPerson);
		}
		if (newPerson.size()>1){
			//throw an exception, but still return the list.
			
		}
		return newPerson;
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


	public Person insertPerson(String firstName, String middleName,
			String lastName, String maidenName, String preferredName,
			PersonType type, String email, String phone, String streetAddress,
			String city, String state, String zip, String country,
			String status, RecruitingEvent recruitingEvent, Document document) {
		// TODO Auto-generated method stub
		return null;
	}

	public Candidate newCandidate(Person person,
			RecruitingEvent recruitingEvent, Document document) {
		Candidate candidate = new Candidate( person.id,
				person.firstName, person.middleName, person.lastName, person.maidenName, person.preferredName, 
				person.updateTime, person.insertTime, person.type, person.email, person.phone, 
				person.streetAddress, person.city, person.state, person.zip, person.country, 
				person.status, recruitingEvent, null, document);
		return candidate;
	}

	public Employee newEmployee(Person person, Document document) {
		Employee employee = new Employee(person.id,
				person.firstName, person.middleName, person.lastName, person.maidenName, person.preferredName, 
				person.updateTime, person.insertTime, person.type, person.email, person.phone, 
				person.streetAddress, person.city, person.state, person.zip, person.country, 
				person.status, null, null, document);
		return employee;
	}

	public Recruiter newRecruiter(Person person) {
		Recruiter recruiter = new Recruiter(person.id,
				person.firstName, person.middleName, person.lastName, person.maidenName, person.preferredName, 
				person.updateTime, person.insertTime, person.type, person.email, person.phone, 
				person.streetAddress, person.city, person.state, person.zip, person.country, 
				person.status);
		return recruiter;
	}









}
