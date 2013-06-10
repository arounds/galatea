import java.awt.List;
import java.util.GregorianCalendar;

public class SchedulingEntry {
	//Attributes
	protected String candidateFirstName;
	protected String candidateLastName;
	protected String currentInterviewType;
	protected String currentInterviewStatus;
	protected GregorianCalendar currentInterviewDateTime;
	protected GregorianCalendar currentInterviewUpdateTime;
	protected List currentInterviewers;
	
	//Constructors
	public SchedulingEntry(String firstName, String lastName,
			String interviewType, String interviewStatus, 
			GregorianCalendar interviewDate, GregorianCalendar interviewUpdateTime,
			List interviewers){
		candidateFirstName = firstName;
		candidateLastName = lastName;
		currentInterviewType = interviewType;
		currentInterviewStatus = interviewStatus;
		currentInterviewDateTime = interviewDate;
		currentInterviewUpdateTime = interviewUpdateTime;
		currentInterviewers = interviewers;
	}
	
	//Methods
	
	public String getCandidateFirstName(){
		return candidateFirstName;
	}
	
	public void setCandidateFirstName(String input){
		candidateFirstName = input;
	}
	
	public String getCandidateLastName(){
		return candidateLastName;
	}
	
	public void setCandidateLastName(String input){
		candidateLastName = input;
	}
	public String getCurrentInterviewType(){
		return currentInterviewType;
	}
	
	public void setCurrentInterviewType(String input){
		currentInterviewType = input;
	}
	
	public String getCurrentInterviewStatus(){
		return currentInterviewStatus;
	}
	
	public void setCurrentInterviewStatus(String input){
		currentInterviewStatus = input;
	}
	
	public GregorianCalendar getCurrentInterviewDateTime(){
		return currentInterviewDateTime;
	}
	
	public void setCurrentInterviewDateTime(GregorianCalendar input){
		currentInterviewDateTime = input;
	}
	
	public GregorianCalendar getCurrentInterviewUpdateTime(){
		return currentInterviewUpdateTime;
	}
	
	public List getCurrentInterviewers(){
		return currentInterviewers;
	}
	
	public void addCurrentInterviewer(){
		//add an interviewer to the list...
	}
	
	

}
