import java.sql.SQLException;

import com.google.cloud.sql.jdbc.CallableStatement;


public interface Factory<A> {
	
	public <A> A createNew();
	public <A> A updateExisting();
	public <A> A getExisting();
	
	public CallableStatement prepareInsert() throws SQLException;
	public CallableStatement prepareUpdate() throws SQLException;
	public CallableStatement prepareSelect() throws SQLException;

}
