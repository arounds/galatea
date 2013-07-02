package model.schedulingEntry;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ListIterator;

import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.ResultSet;

import database.DatabaseManager;


public class SchedulingEntryFactory {
	
	//Attributes
	protected DatabaseManager databaseManager;
		
	//Constructors
	public SchedulingEntryFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}

	//Methods
	public List<SchedulingEntry> getEntries() throws SQLException, ParseException {

		List<SchedulingEntry> schedulingEntries = null;
		ListIterator<SchedulingEntry> iter;
		SchedulingEntry entry = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		ResultSet result = callSelect();
		
		while (result.next()){
            entry.candidateFirstName = result.getString("candidateFirstName");
            entry.candidateLastName = result.getString("candidateLastName");
            entry.currentInterviewType = result.getString("currentInterviewType");
            entry.currentInterviewStatus = result.getString("currentInterviewStatus");
            entry.currentInterviewDateTime.setTime(df.parse(result.getString("currentInterviewDateTime")));
            entry.currentInterviewUpdateTime.setTime(df.parse(result.getString("currentInterviewUpdateTime")));
          //I need to check whether this is already added to the list, with a different interviewer, or if it is a new entry
            iter = schedulingEntries.listIterator();
            while (iter.hasNext()){
            	//I want to test if all the values in a node of the list match the values in entry.
            }
            
            schedulingEntries.add(entry);
            
		}
		result.close();

		
		return schedulingEntries;
	}

	public ResultSet callSelect() throws SQLException {
		Connection conn = databaseManager.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute("CALL selectSchedulingEntry");
		ResultSet rs = (ResultSet) stmt.getResultSet();
		return rs;
	}
	

}
