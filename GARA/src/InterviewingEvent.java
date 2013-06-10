import java.util.List;
import java.util.Calendar;

public class InterviewingEvent {
	//Attributes
	protected Calendar eventDate;
	protected final Calendar _updateTime;
	protected String type;
	protected String status;
	protected List<InterviewEvaluation> listOfInterviewEvals;
	
	//Constructors
	
	public InterviewingEvent(Calendar inputEventDate, 
			Calendar inputUpdateTime, 
			String inputType, String inputStatus, 
			List<InterviewEvaluation> interviewEvals){
		eventDate = inputEventDate;
		_updateTime = inputUpdateTime;
		type = inputType;
		status = inputStatus;
		listOfInterviewEvals = interviewEvals;
	}
	
	//Methods
	public Calendar getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(Calendar input){
		eventDate = input;
	}

	public Calendar getUpdateTime(){
		return _updateTime;
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
	
	public List<InterviewEvaluation> getListOfInterviewEvaluations(){
		return listOfInterviewEvals;
	}
	
	public void addInterviewEval(InterviewEvaluation eval){
		listOfInterviewEvals.add(eval);
	}
}
