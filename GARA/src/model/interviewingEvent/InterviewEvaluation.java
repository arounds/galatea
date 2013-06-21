package model.interviewingEvent;

import model.*;
import model.document.*;
import model.entity.*;
import model.person.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.util.Calendar;

public class InterviewEvaluation {
	//Attributes
	protected String interviewerFirstName;
	protected String interviewerLastName;
	protected Document evaluation;
	protected Calendar updateTime;
	
	//Constructors
	public InterviewEvaluation(String firstName, String lastName, Document evaluation, Calendar update){
		interviewerFirstName = firstName;
		interviewerLastName = lastName;
		this.evaluation = evaluation;
		updateTime = update;
	}
	
	//Methods
	public String getInterviewerFirstName(){
		return interviewerFirstName;
	}
	
	public void setInterviewerFirstName(String interviewerFirstName){
		this.interviewerFirstName = interviewerFirstName;
	}
	
	public String getInterviewerLastName(){
		return interviewerLastName;
	}
	
	public void setInterviewerLastName(String interviewerLastName){
		this.interviewerLastName = interviewerLastName;
	}
	
	public Document getEvaluation(){
		return evaluation;
	}
	
	public void setEvaluation(Document evaluation){
		this.evaluation = evaluation;
	}
	
	public Calendar getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Calendar updateTime){
		this.updateTime = updateTime;
	}
	
}
