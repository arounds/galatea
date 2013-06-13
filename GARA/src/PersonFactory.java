import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.Connection;


public class PersonFactory{

	public Person createNew(String firstName, 
			String middleName, String lastName, 
			String maidenName, String preferredName, 
			String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, 
			String status, List<RecruitingEvent> listREvents, String docFileId, 
			String personType) {
		Calendar updateTime = new GregorianCalendar();
		Person person;
		
		if (personType.equals("candidate")) {
			person = new Candidate(updateTime);
		}
		else if (personType.equals("employee")){
			person = new Employee(updateTime);
		}
		else if (personType.equals("recruiter")){
			person = new Person(updateTime);
		}
		else {
			return null; //I want there to be an error here
		}
		
		person.setFirstName(firstName);
		person.setMiddleName(middleName);
		person.setLastName(lastName);
		//TODO continue
		
		return person;
	}

	public Person updateExisting(String firstName, 
			String middleName, String lastName, 
			String maidenName, String preferredName, 
			String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, 
			String status, List<RecruitingEvent> listREvents, String docFileId) {

		return null;
	}

	public Person getExisting(String firstName, String lastName) {

		return null;
	}

	public CallableStatement prepareInsert(Person person, String personType, String doc_id, String rEvent_id) throws SQLException{
		
		    Connection conn = DatabaseManager.getConnection();
			
			CallableStatement stmt = conn.prepareCall("{CALL insertPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, person.firstName);
			stmt.setString(2, person.middleName);
			stmt.setString(3, person.lastName);
			stmt.setString(4, person.maidenName);
			stmt.setString(5, person.preferredName);
			stmt.setString(6, personType);
			stmt.setString(7, person.email);
			stmt.setString(8, person.phone);
			stmt.setString(9, person.streetAddress);
			stmt.setString(10, person.city);
			stmt.setString(11, person.state);
			stmt.setString(12, person.zipCode);
			stmt.setString(13, person.country);
			stmt.setString(14, doc_id);
			stmt.setString(15, rEvent_id);
			stmt.setString(16, person.status);
			
			return stmt;
	}


	public CallableStatement prepareUpdate() {

		return null;
	}

	public CallableStatement prepareSelect() {

		return null;
	}

}
