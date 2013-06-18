import java.util.Calendar;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;


public class RecruitingEventFactory {
	



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


	public CallableStatement prepareInsert() {
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

}
