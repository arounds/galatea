import java.util.List;
import java.util.Calendar;
import java.util.LinkedList;

public class InterviewingEvent {
	//Attributes
	protected GregorianCalendar eventDate;
	protected GregorianCalendar updateTime;
	protected String type;
	protected String status;
	protected List<InterviewEvaluation> listOfInterviewEvals;
	
	//Constructors
	
	public InterviewingEvent(Calendar inputEventDate, 
			Calendar inputUpdateTime, 
			String inputType, String inputStatus, 
			List interviewEvals){
		eventDate = inputEventDate;
		updateTime = inputUpdateTime;
		type = inputType;
		status = inputStatus;
		listOfInterviewEvals = interviewEvals;
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
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String input){
		status = input;
	}
	
	public List getListOfInterviewEvaluations(){
		return listOfInterviewEvals;
	}
	
	public void addInterviewEval(InterviewEvaluation eval){
		listOfInterviewEvals.add(eval);
	}
}
