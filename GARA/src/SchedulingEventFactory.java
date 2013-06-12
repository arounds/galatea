import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.ListIterator;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.ResultSet;


public class SchedulingEventFactory implements Factory{

	@Override
	public <A> A createNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> A updateExisting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> A getExisting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareSelect() {
		// TODO Auto-generated method stub
		return null;
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
