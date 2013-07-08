package database;

import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.Test;
import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;

public class DatabaseManagerTestCall extends TestCase {

	@Test
	public static void test() throws SQLException{ 
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.registerDriver();
		dbManager.setConnection();
		ResultSet rs = null;
		int id = 0;
		try {
			CallableStatement stmt = dbManager.connection.prepareCall("SELECT id FROM Person WHERE id = 1");
			rs = dbManager.callStatement(stmt);
			assertNotNull(rs);
			while (rs.next()){
				id = rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, id);
	}

}
