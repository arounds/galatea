import java.sql.SQLException;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.Connection;


public class PersonFactory implements Factory{
	protected Person person; 
	protected String personType;
	protected Integer doc_id;
	protected Integer rEvent_id;
	

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
	public CallableStatement prepareInsert() throws SQLException{
		
		    Connection conn = DatabaseManager.getConnection();
			
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
			stmt.setString(14, doc_id.toString());
			stmt.setString(15, rEvent_id.toString());
			stmt.setString(16, person.status);
			
			return stmt;
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

}
