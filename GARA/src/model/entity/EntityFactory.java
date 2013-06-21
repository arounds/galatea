package model.entity;

import model.*;
import model.document.*;
import model.person.*;
import model.interviewingEvent.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;
import model.*;



public class EntityFactory {
	
	//Attributes
		protected DatabaseManager databaseManager;
		
	//Constructors
	public EntityFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}

	//Methods
	public Entity createNew(String name, String type, Person contact, 
			String streetAddress, String city, String state, String zip, String country, 
			String status, Boolean override) throws Exception {
		
		ResultSet rs;
		//Check DB for Entity name
		rs = callDoesEntityNameExist(name);
		Integer entity_id = null;
		while (rs.next()){
			entity_id = rs.getInt("id");
		}
		
		if (entity_id != null){
			if (! override){
				throw new Exception("Entity already exists");
			}
		
		}
		
		rs = null;
		
		//Now get the contact id
		
		//Now insert the entity into the database
		
		//create the entity object

		
		return null;
	}


	public static ResultSet callDoesEntityNameExist(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public Entity updateExisting() {
		Entity entity = null;
		
		// TODO Auto-generated method stub
		//
		
		return entity;
	}


	public Entity getExisting() {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultSet insertEntity(String name, String type, String contact_id, String streetAddress, String city, String state, String zip, String country, String status) {
		// TODO Auto-generated method stub
		return null;
	}


	public CallableStatement prepareUpdate() {
		// TODO Auto-generated method stub
		return null;
	}


	public CallableStatement prepareSelect() {
		// TODO Auto-generated method stub
		return null;
	}

}
