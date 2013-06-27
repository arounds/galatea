package database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;

public class DatabaseManagerTestCall extends TestCase {

	@Test
	public static void test(){ 
		DatabaseManager dbManager = new DatabaseManager();
		ResultSet rs = null;
		try {
			CallableStatement stmt = dbManager.connection.prepareCall("{SELECT id FROM Person WHERE id = 1}");
			rs = dbManager.callStatement(stmt);
			assertNotNull(rs);
			int id = 0;
			while (rs.next()){
				id = rs.getInt("id");
			}
			assertEquals(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
