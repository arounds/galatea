import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;


public abstract class Database {
    //This class contains all the methods required to access the database in anyway. 
	
	//Methods for Accessing the database
	public static void registerDriver() throws SQLException{
		DriverManager.registerDriver(new com.google.cloud.sql.Driver());
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = (Connection) DriverManager.getConnection("jdbc:google:rdbms://galateaassociatesrecruiting:recruiting/recruiting");
		return conn;
	}
	
	//Methods for using procedures
	public Integer insertPerson(Person person, String doc_id, String rEvent_id, String personType) throws SQLException{
		Integer id = 0;
		
		//Search for Recruiting Event id
		Connection conn = getConnection();
		
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
		stmt.execute();
		ResultSet rs = (ResultSet) stmt.getResultSet();
		com.google.cloud.sql.jdbc.ResultSetMetaData rsMetaData = rs.getMetaData();
		System.out.println(rsMetaData.getColumnName(1));
		while (rs.next()){
			id = Integer.parseInt(rs.getString("id"));
		}
		rs.close();
		
		return id;
	}
	
	public static void callDoesPersonIdExist(Connection conn){
		try {
			GregorianCalendar uTime = new GregorianCalendar();
			Candidate cand = new Candidate("Matt", "Smith", uTime);
			
			Statement stmt = conn.createStatement();
			stmt.execute("CALL doesPersonIdExist(1)");
			ResultSet rs = (ResultSet) stmt.getResultSet();
			com.google.cloud.sql.jdbc.ResultSetMetaData rsMetaData = rs.getMetaData();
			System.out.println(rsMetaData.getColumnName(1));
			cand.id = rs.getString("id");
			
			System.out.println(cand.id);
			
			rs.close();
		}
		catch(SQLException SQLEx) {
			System.out.println("MySQL error: "+SQLEx.getErrorCode()+" SQLSTATE:"+SQLEx.getSQLState());
			System.out.println(SQLEx.getMessage());
		}
	}
	
	public static LinkedList<SchedulingEntry> callSelectSchedulingEntry() throws ParseException, SQLException{
		//Calls the stored procedure to get the information for the SchedulingEntry object
		//Then compiles a list of SchedulingEntry objects and returns it.
		
		//Declarations
		Connection conn = getConnection();
		LinkedList<SchedulingEntry> schedulingEntries = null;
		ListIterator<SchedulingEntry> iter;
		SchedulingEntry entry = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
	
		try {
			//Call procedure
			Statement stmt = conn.createStatement();
			stmt.execute("CALL selectSchedulingEntry");
			ResultSet rs = (ResultSet) stmt.getResultSet();
			//Access the ResultSet and populate the list
			while (rs.next()){
                entry.candidateFirstName = rs.getString("candidateFirstName");
                entry.candidateLastName = rs.getString("candidateLastName");
                entry.currentInterviewType = rs.getString("currentInterviewType");
                entry.currentInterviewStatus = rs.getString("currentInterviewStatus");
                entry.currentInterviewDateTime.setTime(df.parse(rs.getString("currentInterviewDateTime")));
                entry.currentInterviewUpdateTime.setTime(df.parse(rs.getString("currentInterviewUpdateTime")));
                //I need to check whether this is already added to the list, with a different interviewer, or if it is a new entry
                iter = schedulingEntries.listIterator();
                while (iter.hasNext()){
                	//I want to test if all the values in a node of the list match the values in entry.
                }
                
                schedulingEntries.add(entry);
                
			}
			rs.close();
			
		}
		catch(SQLException SQLEx) {
			System.out.println("MySQL error: "+SQLEx.getErrorCode()+" SQLSTATE:"+SQLEx.getSQLState());
			System.out.println(SQLEx.getMessage());
		}
		return schedulingEntries;
	}


}
