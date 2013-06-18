import java.sql.SQLException;
import java.util.Calendar;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;


public class DocumentFactory {
	
	//Constructors
	
	//Methods
	public void createNewDocument(String type, Calendar submitDate, String title, String fileLocation) throws SQLException{
		ResultSet result = callInsertDocument(type, submitDate, title, fileLocation);
		//parse result
	}
	public void getExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO call the stored procedure to create a new doc
	}
	public void updateExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO call the stored procedure to create a new doc
	}
	public ResultSet callSelectExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		return null;
		//TODO prepare the call to the stored procedure selectDocument
	}
	public ResultSet callInsertDocument(String type, Calendar submitDate, String title, String fileLocation){
		return null;
		//TODO prepare the call to the stored procedure insertDocument
	}
	public ResultSet callUpdateDocument(String id, String type, Calendar submitDate, String title, String fileLocation){
		return null;
		//TODO prepare the call to the stored procedure updateDocument
	}
	

}
