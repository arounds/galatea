import java.util.Calendar;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;


public class RecruitingEventFactory {
	
	//Attributes
	protected DatabaseManager databaseManager;
		
	//Constructors
	public RecruitingEventFactory(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}

	//Methods
	public RecruitingEvent createNew() {
		
		/*
		 * Note: The fields that cannot be null in the Database are:
		 * 		- eventDateTime
		 * 		- type
		 * 		- entity_id
		 * 	   (- updateTime and insertTime)
		 * These should be take care of when creating a new RecruitingEvent
		 */
		// TODO Auto-generated method stub
		return null;
	}


	public RecruitingEvent updateExisting() {
		// TODO Auto-generated method stub
		return null;
	}


	public RecruitingEvent getExisting() {
		// TODO Auto-generated method stub
		return null;
	}





	public ResultSet callUpdate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ResultSet callGetID(RecruitingEvent rEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ResultSet callSelect(String rEvent_id) {
		// TODO Auto-generated method stub
		return null;
	}


	public static ResultSet callDoesRecruitingEventExist(Calendar eventDate,
			String type, String entity_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RecruitingEvent> getEmployeesRecruitingEvents(Integer person_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RecruitingEvent getPersonsRecruitingEvent(Integer person_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getRecruitingEventId(RecruitingEvent rEvent) {
		/**
		 * Obtains the database id for the given recruiting event.
		 * It first finds the entity id, then finds the recruiting event id.
		 * 
		 * @param	 entity_id 		an integer representing the database id for the entity
		 * @param 	 rEvent_id		an integer representing the database id for the recruiting event
		 * @return	 rEvent_id
		 */
		
		return null;
	}
	
	public CallableStatement prepareInsert() {
		// TODO Auto-generated method stub
		return null;
	}




}
