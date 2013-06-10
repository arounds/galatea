import java.util.GregorianCalendar;
import java.util.LinkedList;

public class RecruitingEvent {
	//Attributes
	protected GregorianCalendar eventDate;
	protected GregorianCalendar updateTime;
	protected String type;
	protected String entityName;
	protected String location;
	protected LinkedList<Employee> listOfAttendees;
	
	//Constructors
	public RecruitingEvent(GregorianCalendar inputUpdateTime, 
			String inputType){
		updateTime = inputUpdateTime;
		type = inputType;
	}
	
	public RecruitingEvent(GregorianCalendar inputEventDate, 
			GregorianCalendar inputUpdateTime,
			String inputType, String inputEntity, String inputLocation, 
			LinkedList<Employee> attendees){
		eventDate = inputEventDate;
		updateTime = inputUpdateTime;
		type = inputType;
		entityName = inputEntity;
		location = inputLocation;
		listOfAttendees = attendees;
	}
	
	//Methods
	
	public GregorianCalendar getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(GregorianCalendar input){
		eventDate = input;
	}

	public GregorianCalendar getUpdateTime(){
		return updateTime;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String input){
		type = input;
	}
	
	public LinkedList<Employee> getListOfAttendees(){
		return listOfAttendees;
	}
	
	public void addAttendee(Employee emp){
		listOfAttendees.add(emp);
	}
	

}
