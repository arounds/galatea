import java.sql.DriverManager;
import java.sql.SQLException;
import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.ResultSet;


public class DatabaseManager {

	public static void registerDriver() throws SQLException{
		DriverManager.registerDriver(new com.google.cloud.sql.Driver());
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = (Connection) DriverManager.getConnection("jdbc:google:rdbms://galateaassociatesrecruiting:recruiting/recruiting");
		return conn;
	}
	
	public static ResultSet callStatement(CallableStatement stmt) throws SQLException{
		stmt.execute();
		ResultSet rs = (ResultSet) stmt.getResultSet();
		return rs;
	}

}
