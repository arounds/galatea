import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
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
			String status, RecruitingEvent rEvent, 
			String docTitle, Calendar docSubmitDate, String docFileId, 
			String personType, Boolean override) throws SQLException {
		//Variables
		Calendar updateTime = null;
		Person person = null;
		ResultSet result;
		Integer rEvent_id = null;
		Integer entity_id = null;
		Integer doc_id = null;
		
		
		//Check if person is in the database
		try{
			result = callDoesPersonFirstLastNameExist(firstName, lastName);
			List<String> idList = new LinkedList<String>();
			//get results
			while (result.next()){
				String id = result.getString("id");
				idList.add(id);
			}
			if (idList.size() == 0){  //ie. if there is no person with this name
				//continue
			}
			else {  //ie. there is at least one person with this name
				if (override){
					//continue
				}
				else if (! override){
					//return an error to the controller
					//I think we want to create an exception that will handle this...
				}
			}
		}
		catch (SQLException ex){
			
		}
		
		//reinitialize result
		result = null;
		
		//Find id for entity
		try{
			result = EntityFactory.callDoesEntityNameExist(rEvent.entityName);
			while (result.next()){
				entity_id = result.getInt("id"); //since Entity.name is unique in the db, this only loops once
			}
			
			
			//reinitialize result
			result = null;
		
			//Find id for recruiting event
			result = RecruitingEventFactory.callDoesRecruitingEventExist(rEvent.eventDate, rEvent.type, entity_id.toString());
			//interpret result
			while (result.next()){
				rEvent_id = result.getInt("id");
			}
		}
		catch (SQLException ex){
			
		}
		catch (NullPointerException ex){
			//break and tell controller that entity cant be null
		}
		
		//reinitialize result 
		result = null;
		//Create the document and get the id
		result = DocumentFactory.callInsert(docSubmitDate, docTitle, docFileId);
		
		
		//reinitialize result
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
			//Determine which constructor to use based on personType
		
		
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
			String state, String zipCode, String country, Integer rEvent_id, Integer doc_id, 
			String status) throws SQLException{
		
		/* Prepares a call to the insertPerson stored procedure and 
		 * executes that statement. 
		 * The ResultSet contains the database updateTime.
		 */
		
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
			if (doc_id != null){
				stmt.setString(14, doc_id.toString());
			}
			else {
				stmt.setString(14,  null);
			}
			if (rEvent_id != null){
				stmt.setString(15, rEvent_id.toString());
			}
			else {
				stmt.setString(15,  null);
			}
			stmt.setString(16, status);
			
			ResultSet result = DatabaseManager.callStatement(stmt);
			return result;
	}


	public ResultSet updatePerson(String id, String firstName, String middleName, String lastName, 
			String maidenName, String preferredName, String personType, String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, String rEvent_id, String doc_id, 
			String status) throws SQLException {
		
		/* Prepares a call to the updatePerson stored procedure and 
		 * executes that statement. 
		 * The ResultSet contains the database updateTime.
		 */
		
		Connection conn = DatabaseManager.getConnection();
		
		CallableStatement stmt = conn.prepareCall("{CALL updatePerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		stmt.setString(1, id);
		stmt.setString(2, firstName);
		stmt.setString(3, middleName);
		stmt.setString(4, lastName);
		stmt.setString(5, maidenName);
		stmt.setString(6, preferredName);
		stmt.setString(7, personType);
		stmt.setString(8, email);
		stmt.setString(9, phone);
		stmt.setString(10, streetAddress);
		stmt.setString(11, city);
		stmt.setString(12, state);
		stmt.setString(13, zipCode);
		stmt.setString(14, country);
		stmt.setString(15, doc_id);
		stmt.setString(16, rEvent_id);
		stmt.setString(17, status);
		
		ResultSet result = DatabaseManager.callStatement(stmt);
		return result;
	}

	public ResultSet prepareSelect(String id) throws SQLException {
		
		/* Prepares a call to the selectPerson stored procedure and 
		 * executes that statement. 
		 * The ResultSet contains all information on that person.
		 * 
		 * Note: I use the id to select a person because it is reliable to 
		 * select a specific person. Searching for a person's id number 
		 * should be performed in a separate method (ie. callDoesPersonFirstLastNameExist).
		 */
		
		Connection conn = DatabaseManager.getConnection();
		
		CallableStatement stmt = conn.prepareCall("{CALL selectPerson(?)}");
		stmt.setString(1, id);

		ResultSet result = DatabaseManager.callStatement(stmt);
		return result;
	}

}
