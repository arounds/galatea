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
			String status, RecruitingEvent rEvent, String docFileId, 
			String personType) {
		//Variables
		Calendar updateTime;
		Person person;
		CallableStatement stmt;
		String doc_id;
		
		//Check if person is in the database
		
		
		
		//Create the document and get the id
		
		
		//Insert the person into the database
		stmt = prepareInsert(firstName, middleName, lastName, maidenName, preferredName, personType, email, phone, streetAddress, city, state, zipCode, country, rEvent.DBid, doc_id, status)
		
		//Create the Person object
		
		//Return the created person
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

	public CallableStatement prepareInsert(String firstName, String middleName, String lastName, 
			String maidenName, String preferredName, String personType, String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, String rEvent_id, String doc_id, 
			String status) throws SQLException{
		
		    Connection conn = DatabaseManager.getConnection();
			
			CallableStatement stmt = conn.prepareCall("{CALL insertPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, firstName);
			stmt.setString(2, middleName);
			stmt.setString(3, lastName);
			stmt.setString(4, maidenName);
			stmt.setString(5, preferredName);
			stmt.setString(6, personType);
			stmt.setString(7, email);
			stmt.setString(8, phone);
			stmt.setString(9, streetAddress);
			stmt.setString(10, city);
			stmt.setString(11, state);
			stmt.setString(12, zipCode);
			stmt.setString(13, country);
			stmt.setString(14, doc_id);
			stmt.setString(15, rEvent_id);
			stmt.setString(16, status);
			
			return stmt;
	}


	public CallableStatement prepareUpdate() {

		return null;
	}

	public CallableStatement prepareSelect() {

		return null;
	}

}
