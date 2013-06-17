import java.util.List;
import java.util.Calendar;

public class SchedulingEntry {
	//Attributes
	protected String candidateFirstName;
	protected String candidateLastName;
	protected String currentInterviewType;
	protected String currentInterviewStatus;
	protected Calendar currentInterviewDateTime;
	protected Calendar currentInterviewUpdateTime;
	protected List<Employee> currentInterviewers;
	
	//Constructors
	public SchedulingEntry(String firstName, String lastName,
			String interviewType, String interviewStatus, 
			Calendar interviewDate, Calendar interviewUpdateTime,
			List<Employee> interviewers){
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
	
	public Calendar getCurrentInterviewDateTime(){
		return currentInterviewDateTime;
	}
	
	public void setCurrentInterviewDateTime(Calendar input){
		currentInterviewDateTime = input;
	}
	
	public Calendar getCurrentInterviewUpdateTime(){
		return currentInterviewUpdateTime;
	}
	
	public List<Employee> getCurrentInterviewers(){
		return currentInterviewers;
	}
	
	public void addCurrentInterviewer(Employee interviewer){
		currentInterviewers.add(interviewer);
	}
	
	

}
