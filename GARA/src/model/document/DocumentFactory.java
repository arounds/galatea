package model.document;

import model.*;
import model.entity.*;
import model.person.*;
import model.interviewingEvent.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.sql.SQLException;
import java.util.Calendar;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;

import database.DatabaseManager;


public class DocumentFactory {
	
	//Attributes
	protected DatabaseManager databaseManager;
	
	//Constructors
	public DocumentFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}
	
	//Methods

	public ResultSet callInsertDocument(String type, Calendar submitDate, String title, String fileLocation){
		return null;
		//TODO prepare the call to the stored procedure insertDocument
	}
	public ResultSet callSelectExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		return null;
		//TODO prepare the call to the stored procedure selectDocument
	}
	public ResultSet callUpdateDocument(String id, String type, Calendar submitDate, String title, String fileLocation){
		return null;
		//TODO prepare the call to the stored procedure updateDocument
	}
	public void createNewDocument(String type, Calendar submitDate, String title, String fileLocation) throws SQLException{
		ResultSet result = callInsertDocument(type, submitDate, title, fileLocation);
		//parse result
	}
	public Integer getDocumentId(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	public void getExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO call the stored procedure to create a new doc
	}
	public Document getPersonsDocument(Integer person_id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateExistingDocument(String type, Calendar submitDate, String title, String fileLocation){
		//TODO call the stored procedure to create a new doc
	}

}
