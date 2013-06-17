import java.sql.SQLException;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;


public class EntityFactory {

	public Entity createNew(String name, String type, Person contact, 
			String streetAddress, String city, String state, String zip, String country, 
			String status, Boolean override) throws SQLException {
		
		ResultSet rs;
		//Check DB for Entity name
		rs = callDoesEntityNameExist(name);
		Integer entity_id;
		while (rs.next()){
			entity_id = rs.getInt("id");
		}
		
		if (entity_id != null){
			if (! override){
				throw new Exception("Entity already exists");
			}
		}
		
		rs = null;
		
		rs = PersonFactory.

		
		return entity;
	}


	public ResultSet callDoesEntityNameExist(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public <Entity> Entity updateExisting() {
		Entity entity = null;
		
		// TODO Auto-generated method stub
		//
		
		return entity;
	}


	public <A> A getExisting() {
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
