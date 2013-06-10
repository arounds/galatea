import java.util.Calendar;

public class InterviewEvaluation {
	//Attributes
	protected String interviewerFirstName;
	protected String interviewerLastName;
	protected String evaluationFileID;
	protected final Calendar _updateTime;
	
	//Constructors
	public InterviewEvaluation(Calendar update){
		_updateTime = update;
	}
	
	public InterviewEvaluation(String firstName, String lastName, Calendar update){
		interviewerFirstName = firstName;
		interviewerFirstName = lastName;
		_updateTime = update;
	}
	
	public InterviewEvaluation(String firstName, String lastName, String fileId, Calendar update){
		interviewerFirstName = firstName;
		interviewerLastName = lastName;
		evaluationFileID = fileId;
		_updateTime = update;
	}
	
	//Methods
	public String getInterviewerFirstName(){
		return interviewerFirstName;
	}
	
	public void setInterviewerFirstName(String x){
		interviewerFirstName = x;
	}
	
	public String getInterviewerLastName(){
		return interviewerLastName;
	}
	
	public void setInterviewerLastName(String x){
		interviewerLastName = x;
	}
	
	public String getEvaluationFileID(){
		return evaluationFileID;
	}
	
	public void setEvaluationFileID(String x){
		evaluationFileID = x;
	}
	
	public Calendar getUpdateTime(){
		return _updateTime;
	}
	
}
