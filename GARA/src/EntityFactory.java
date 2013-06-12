import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;


public class EntityFactory implements Factory{

	@Override
	public <Entity> Entity createNew() {
		Entity entity = null;
		CallableStatement stmt;
		ResultSet rs;
		
		// TODO write code to create an Entity object
		//
		//stmt = prepareInsert(Entity);
		//rs = DatabaseManager.callStatement(stmt);
		
		return entity;
	}

	@Override
	public <Entity> Entity updateExisting() {
		Entity entity = null;
		
		// TODO Auto-generated method stub
		//
		
		return entity;
	}

	@Override
	public <A> A getExisting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareInsert(Entity entity) {
		// TODO Auto-generated method stub
		return null;
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
