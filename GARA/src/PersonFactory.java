import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.ResultSet;


public class PersonFactory {

	public Person createNew(String firstName, 
			String middleName, String lastName, 
			String maidenName, String preferredName, 
			String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, 
			String status, RecruitingEvent rEvent, String docFileId, 
			String personType, Boolean override) {
		//Variables
		Calendar updateTime;
		Person person;
		CallableStatement stmt;
		ResultSet result;
		String rEvent_id = null;
		String doc_id = null;
		
		
		//Check if person is in the database
		try{
			stmt = prepareDoesPersonFirstLastNameExist(firstName, lastName);
			result = DatabaseManager.callStatement(stmt);
			List<String> idList = new LinkedList<String>();
			//interpret result
			while (result.next()){
				String id = result.getString("id");
				idList.add(id);
			}
			if (idList.size() == 0){
				//continue
			}
			else {
				if (override == 1){
					//continue
				}
				else if (override == 0){
					//return an error to the controller
				}
			}
		}
		catch (SQLException ex){
			
		}
		
		//reinitialize result and stmt
		stmt = null;
		result = null;
		//Find id for recruiting event
		stmt = RecruitingEvent.prepareGetID(rEvent);
		result = DatabaseManager.callStatement(stmt);
		//interpret result
		
		//reinitialize result and stmt
		stmt = null;
		result = null;
		//Create the document and get the id
		
		
		//reinitialize result and stmt
		stmt = null;
		result = null;
		//Insert the person into the database
		result = insertPerson(firstName, middleName, lastName, 
				maidenName, preferredName, personType, email, phone, 
				streetAddress, city, state, zipCode, country, rEvent_id, doc_id, status);
		while (result.next()){
			Timestamp updateTimestamp = result.getTimestamp("updateTime");
			updateTime.setTimeInMillis(updateTimestamp.getTime());
		}
		//Create the Person object
		
		//Return the created person
		return person;
	}

	public static ResultSet callDoesPersonFirstLastNameExist(String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		return null;
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

	public ResultSet insertPerson(String firstName, String middleName, String lastName, 
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
			
			ResultSet result = DatabaseManager.callStatement(stmt);
			return result;
	}


	public ResultSet updatePerson() {

		return null;
	}

	public ResultSet prepareSelect() {

		return null;
	}

}
