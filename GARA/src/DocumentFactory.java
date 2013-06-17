import java.sql.SQLException;
import java.util.Calendar;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;


public class DocumentFactory {
	
	//Constructors
	
	//Methods
	public void createNewDocument(String type, Calendar submitDate, String title, String fileLocation) throws SQLException{
		CallableStatement stmt = prepareInsertDocument(type, submitDate, title, fileLocation);
		ResultSet result = DatabaseManager.callStatement(stmt);
		//parse result
	}
	public void getExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO call the stored procedure to create a new doc
	}
	public void updateExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO call the stored procedure to create a new doc
	}
	public CallableStatement prepareSelectExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO prepare the call to the stored procedure selectDocument
	}
	public CallableStatement prepareInsertDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO prepare the call to the stored procedure insertDocument
	}
	public CallableStatement prepareUpdateDocument(String id, String type, Calendar submitDate, String title, String fileLocation){
		//TODO prepare the call to the stored procedure updateDocument
	}
	

}
