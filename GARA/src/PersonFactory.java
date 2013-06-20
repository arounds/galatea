import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.ResultSet;


public class PersonFactory {
	/**
	 * Creates Person objects and facilitates interaction between the Controller and the DatabaseManager.
	 * 
	 * @author 	rounds
	 * @updated 2013-06-19 04:43 PM
	 */
	//Attributes
	protected DatabaseManager databaseManager;
	public enum PersonType{
		CANDIDATE, EMPLOYEE, RECRUITER
	}
	
	//Constructors
	public PersonFactory(){};
	
	public PersonFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}
	
	//Methods
/*-------------------------------------------------------------------------------------------------------------------------*/	
	public Boolean checkIfPersonExists(String firstName, String lastName) {
		/**
		 * Checks if there is a person in the database with the given first and last names.
		 * Returns True if a person does exist.
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param	exists	a boolean valued 'true' if a person exists in the database with the given name
		 * @param 	stmt 	a CallableStatement to the stored procedure doesPersonFirstLastNameExist
		 * @param	rs		the ResultSet from stmt, containing a Boolean value
		 * @return	exists 	
		 */
		
		CallableStatement stmt = prepareCall_doesPersonFirstLastNameExist(firstName, lastName);
		ResultSet rs = null;
		try{
			rs = databaseManager.callStatement(stmt);
		}
		catch (SQLException ex){
			
		}
		Boolean exists = interpretResultSet_existance(rs);
		return exists;
	}
	
/*-------------------------------------------------------------------------------------------------------------------------*/
	public Candidate createCandidateObject(Person person, RecruitingEvent rEvent,
			List<InterviewingEvent> listOfInterviewingEvents, Document resume) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*-------------------------------------------------------------------------------------------------------------------------*/
	public Person createEmployeeObject(Person person,
			List<RecruitingEvent> listOfRecruitingEvents,
			List<InterviewingEvent> listOfInterviewingEvents, Document contract) {
		// TODO Auto-generated method stub
		return null;
	}

/*-------------------------------------------------------------------------------------------------------------------------*/
	public Person createPersonObject(String firstName,
			String middleName, String lastName, String maidenName,
			String preferredName, PersonType type, String email,
			String phone, String streetAddress, String city, String state,
			String zipCode, String country, String status, RecruitingEvent rEvent, Document doc) {
		/**
		 * Creates a Person object with the given values.
		 * It determines which constructor to use based on the personType.
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param 	person	a Person object.
		 * @return	person
		 */
		Person person = null;
		
		switch (type){
		case CANDIDATE: 
			person = new Candidate(firstName, middleName, lastName, maidenName, preferredName, 
					email, phone, streetAddress, city, state, zipCode, country, status, null, rEvent, null, doc);
			break;
		case EMPLOYEE:
			person = new Employee(firstName, middleName, lastName, maidenName, preferredName, 
					email, phone, streetAddress, city, state, zipCode, country, status, null);
			break;
		case RECRUITER:
			person = new Recruiter(firstName, middleName, lastName, maidenName, preferredName, 
					email, phone, streetAddress, city, state, zipCode, country, status, null);
			break;
		}
		
		return person;
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------*/
	public Calendar insertPerson(Person person, PersonType personType,
			Integer rEvent_id, Integer doc_id) {
		/**
		 * Inserts the person into the database
		 * 
		 * @author 	rounds
		 * @updated 2013-06-20 09:41 AM
		 * 
		 * @param	stmt		a CallableStatement calling the insertPerson procedure
		 * @param	rs			the ResultSet from the insertPerson procedure, containing an updateTime
		 * @param	updateTime	a Calendar object representing the time the person was updated in the database
		 * @return	updateTime
		 */
		ResultSet rs = null;
		
		
		CallableStatement stmt = prepareCall_insertPerson(person, personType.toString(), rEvent_id, doc_id);
		try {
			rs = databaseManager.callStatement(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar updateTime = interpretResultSet_updateTime(rs);
		
		return updateTime;
	}
	
	protected CallableStatement prepareCall_insertPerson(Person person,
			String personType, Integer rEvent_id, Integer doc_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	protected Boolean interpretResultSet_existance(ResultSet rs) {
		/**
		 * Extracts a boolean value from a ResultSet.
		 * Can be used with any stored procedure which 
		 * returns a single Boolean value. Currently used for 
		 * any stored procedure in the database ending with the word
		 * 'Exist'.
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 04:54 PM
		 * 
		 * @param
		 * @return
		 */
		
		// TODO Auto-generated method stub
		return null;
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------*/
	protected Calendar interpretResultSet_updateTime(ResultSet rs) {
		/**
		 * Extracts a Calendar instance from a ResultSet.
		 * Can be used with any stored procedure which 
		 * returns an sql TIMESTAMP. Currently used for 
		 * any stored procedure in the database which inserts
		 * or updates an entry. 
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 04:54 PM
		 * 
		 * @param
		 * @return
		 */
		
		// TODO Auto-generated method stub
		return null;
	}
/*-------------------------------------------------------------------------------------------------------------------------*/	
	protected CallableStatement prepareCall_doesPersonFirstLastNameExist(
			String firstName, String lastName) {
		/**
		 * Prepares the CallableStatement to call procedure doesPersonFirstLastNameExist.
		 * 
		 * + doesPersonFirstLastNameExist(VARCHAR(50) firstName, VARCHAR(50) lastName) : BOOLEAN exists
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 04:54 PM
		 * 
		 * @param 	stmt	the CallableStatement
		 * @return	stmt
		 */
		
		// TODO Auto-generated method stub
		return null;
	}
/*-------------------------------------------------------------------------------------------------------------------------*/
	public Person updateExisting(String firstName, 
			String middleName, String lastName, 
			String maidenName, String preferredName, 
			String type, String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, 
			String status, List<RecruitingEvent> listREvents, String docFileId) {
		/**
		 * What does this method do?
		 * How does it do it, briefly?
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param
		 * @return
		 */

		return null;
	}
/*-------------------------------------------------------------------------------------------------------------------------*/
	public Person getExisting(String firstName, String lastName) {
		/**
		 * What does this method do?
		 * How does it do it, breifly?
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param
		 * @return
		 */

		return null;
	}


/*-------------------------------------------------------------------------------------------------------------------------*/
	public Person getPerson(Integer person_id) {
		/**
		 * What does this method do?
		 * How does it do it, briefly?
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param
		 * @return
		 */
		
		// TODO Auto-generated method stub
		return null;
	}
/*-------------------------------------------------------------------------------------------------------------------------*/
	public List<Integer> getPersonId(String firstName, String lastName) {
		/**
		 * What does this method do?
		 * How does it do it, briefly?
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param
		 * @return
		 */
		
		// TODO Auto-generated method stub
		return null;
	}

/*-------------------------------------------------------------------------------------------------------------------------*/
	public ResultSet prepareSelect(String id) throws SQLException {
		
		/** Prepares a call to the selectPerson stored procedure and 
		 * executes that statement. 
		 * The ResultSet contains all information on that person.
		 * 
		 * Note: I use the id to select a person because it is reliable to 
		 * select a specific person. Searching for a person's id number 
		 * should be performed in a separate method (ie. callDoesPersonFirstLastNameExist).
		 */
		
		Connection conn = databaseManager.getConnection();
		
		CallableStatement stmt = conn.prepareCall("{CALL selectPerson(?)}");
		stmt.setString(1, id);

		ResultSet result = databaseManager.callStatement(stmt);
		return result;
	}
/*-------------------------------------------------------------------------------------------------------------------------*/
	public Calendar updatePerson(Integer person_id, Person person, PersonType personType,
			Integer rEvent_id, Integer doc_id) {
		/**
		 * What does this method do?
		 * How does it do it, briefly?
		 * 
		 * @author 	rounds
		 * @updated 2013-06-19 01:31 PM
		 * 
		 * @param
		 * @return
		 */
		
		// TODO Auto-generated method stub
		return null;
	}
/*-------------------------------------------------------------------------------------------------------------------------*/
	public ResultSet updatePerson(String id, String firstName, String middleName, String lastName, 
			String maidenName, String preferredName, String personType, String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, String rEvent_id, String doc_id, 
			String status) throws SQLException {
		
		/** Prepares a call to the updatePerson stored procedure and 
		 * executes that statement. 
		 * The ResultSet contains the database updateTime.
		 */
		
		CallableStatement stmt = databaseManager.connection.prepareCall("{CALL updatePerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
		
		ResultSet result = databaseManager.callStatement(stmt);
		return result;
	}
	
	///////////////////////////////////////////////////////
	/////////////////// ARCHIVED //////////////////////////
	///////////////////////////////////////////////////////
	
	public ResultSet ARCHIVEDinsertPerson(String firstName, String middleName, String lastName, 
			String maidenName, String preferredName, String personType, String email, String phone, 
			String streetAddress, String city, 
			String state, String zipCode, String country, Integer rEvent_id, Integer doc_id, 
			String status) throws SQLException{
		
		/** Prepares a call to the insertPerson stored procedure.
		 *  
		 * 
		 */
			
			CallableStatement stmt = databaseManager.connection.prepareCall("{CALL insertPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
			
			ResultSet result = databaseManager.callStatement(stmt);
			return result;
	}






}
