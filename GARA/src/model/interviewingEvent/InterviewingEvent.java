package model.interviewingEvent;

import model.*;
import model.document.*;
import model.entity.*;
import model.person.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.util.List;
import java.util.Calendar;

public class InterviewingEvent {
	//Attributes
	protected Integer id;
	protected Integer candidate_id;
	protected Calendar updateTime;
	protected Calendar insertTime;
	protected Calendar eventDateTime;
	protected String type;
	protected String status;
	protected Candidate candidate;
	protected List<InterviewEvaluation> listOfInterviewEvals;
	
	//Constructors
	
	public InterviewingEvent(Calendar inputEventDate, 
			Calendar inputUpdateTime, 
			String inputType, String inputStatus, 
			List<InterviewEvaluation> interviewEvals){
		eventDateTime = inputEventDate;
		updateTime = inputUpdateTime;
		type = inputType;
		status = inputStatus;
		listOfInterviewEvals = interviewEvals;
	}
	
	//Methods
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Calendar getEventDate(){
		return eventDateTime;
	}
	
	public void setEventDate(Calendar input){
		eventDateTime = input;
	}

	public Calendar getUpdateTime(){
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
	
	public List<InterviewEvaluation> getListOfInterviewEvaluations(){
		return listOfInterviewEvals;
	}
	
	public void addInterviewEval(InterviewEvaluation eval){
		listOfInterviewEvals.add(eval);
	}
}
