import java.awt.List;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class InterviewingEvent {
	//Attributes
	protected GregorianCalendar eventDate;
	protected GregorianCalendar updateTime;
	protected String type;
	protected String status;
	protected List<InterviewEvaluation> listOfInterviewEvaluations;
	
	//Constructors
	public InterviewingEvent(GregorianCalendar inputUpdateTime, String inputType, 
			String inputStatus){
		//define eventDateTime
		updateTime = inputUpdateTime;
		type = inputType;
		status = inputStatus;
		//define listOfInterviewEvals
	}
	
	public InterviewingEvent(GregorianCalendar inputEventDate, GregorianCalendar inputUpdateTime, 
			String inputType, String inputStatus, 
			List interviewEvals){
		eventDate = inputEventDate;
		updateTime = inputUpdateTime;
		type = inputType;
		status = inputStatus;
		listOfInterviewEvaluations = interviewEvals;
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
		return listOfInterviewEvaluations;
	}
	
	public void addInterviewEval(InterviewEvaluation eval){
		listOfInterviewEvaluations.add(eval);
	}
}
