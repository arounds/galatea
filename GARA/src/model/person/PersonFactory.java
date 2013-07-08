package model.person;

import model.document.*;
import model.person.Person.PersonType;
import model.recruitingEvent.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

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
	protected RowMapper personRowMapper;
	protected RowMapperResultSetExtractor rowMapperResultSetExtractor;
	
	//Constructors
	public PersonFactory(){}
	
	public PersonFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
		this.personRowMapper = new PersonRowMapper();
		this.rowMapperResultSetExtractor = new RowMapperResultSetExtractor(personRowMapper);
	}
	
	//Methods

	public List<Person> createAndInsertNewPerson(String firstName,
			String middleName, String lastName, String maidenName,
			String preferredName, PersonType type, String email, String phone,
			String streetAddress, String city, String state, String zip,
			String country, String status, RecruitingEvent recruitingEvent,
			Document document) throws SQLException {
		List<Person> people = new ArrayList<Person>(1);
		
		List<Person> person = insertPerson(firstName, middleName, 
				lastName, maidenName, preferredName, type, email, phone, 
				streetAddress, city, state, zip, country, 
				status, recruitingEvent, document);
		switch (type){
		case CANDIDATE: 
			Candidate candidate = newCandidate(person.get(0), recruitingEvent, document);
			people.add(candidate);
			break;
		case EMPLOYEE: 
			Employee employee = newEmployee(person.get(0), document);
			people.add(employee);
			break;
		case RECRUITER:
			Recruiter recruiter = newRecruiter(person.get(0));
			people.add(recruiter);
			break;
		}
		return people;
	}

	protected CallableStatement prepareCall_insertPerson(Person person) throws SQLException {
		CallableStatement stmt = databaseManager.connection.prepareCall("CALL insertPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		stmt.setString(1, person.firstName);
		stmt.setString(2, person.middleName);
		stmt.setString(3, person.lastName);
		stmt.setString(4, person.maidenName);
		stmt.setString(5, person.preferredName);
		stmt.setString(6, person.type.toString());
		stmt.setString(7, person.email);
		stmt.setString(8, person.phone);
		stmt.setString(9, person.streetAddress);
		stmt.setString(10, person.city);
		stmt.setString(11, "MA");
		stmt.setString(12, person.zip);
		stmt.setString(13, "USA");
		if (person.doc_id == null){
			stmt.setNull(14, java.sql.Types.INTEGER);
		}
		else {
			stmt.setInt(14, person.doc_id);
		}
		if (person.recruitingEvent_id == null){
			stmt.setNull(15, java.sql.Types.INTEGER);
		}
		else {
			stmt.setInt(15, person.recruitingEvent_id);
		}
		stmt.setString(16, person.status);
		return stmt;
	}


	public List<Person> insertPerson(String firstName, String middleName,
			String lastName, String maidenName, String preferredName,
			PersonType type, String email, String phone, String streetAddress,
			String city, String state, String zip, String country,
			String status, RecruitingEvent recruitingEvent, Document document) throws SQLException {
		
		Calendar now = Calendar.getInstance();
		Person person = new Person(null, firstName, middleName, lastName, maidenName, preferredName, now, now, type, email, phone, streetAddress, city, state, zip, country, null, null, status);
		CallableStatement stmt = null;
		try{
			stmt = prepareCall_insertPerson(person); //System.out.println("i prepared the call.");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		ResultSet rs_person = null;
		try{
			rs_person = databaseManager.callStatement(stmt); //System.out.println("i called and got a return statement.");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		List<Person> newPerson = rowMapperResultSetExtractor.extractData(rs_person);
		
		if (newPerson.size()>1){
			//throw an exception, but still return the list.
			
		}
		if (newPerson.size()<1){
			System.out.println("Insertion did not work.");
			
			return null;
		}
		return newPerson;
		
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
