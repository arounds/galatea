package model.person;

import model.*;
import model.document.*;
import model.entity.*;
import model.interviewingEvent.*;
import model.person.Person.PersonType;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.util.Calendar;
import java.util.List;



public class Employee extends Person{
	//Attributes
	protected List<RecruitingEvent> recruitingEvents;
	protected List<InterviewingEvent> interviewingEvents;
	protected Document contract;
		
	//Constructors
	public Employee(Integer id, String firstName, String middleName, String lastName, 
			String maidenName, String preferredName, Calendar updateTime, 
			Calendar insertTime, PersonType type, String email,
			String phone, String streetAddress, String city,
			String state, String zip, String country, 
			Integer doc_id, Integer rEvent_id, String status, 
			List<RecruitingEvent> recruitingEvents, List<InterviewingEvent> interviewingEvents, 
			Document contract){
		super(id, firstName, middleName, lastName, maidenName, preferredName, 
				updateTime, insertTime,
				type, email, phone, 
				streetAddress, city, state, zip, country, 
				doc_id, rEvent_id, status);
		this.recruitingEvents = recruitingEvents;
		this.interviewingEvents = interviewingEvents;
		this.contract = contract;
	}
	//Methods
	public List<RecruitingEvent> getRecruitingEvents(){
		return recruitingEvents;
	}
	
	public void addRecruitingEvent(RecruitingEvent event){
		recruitingEvents.add(event);
	}
	
	public List<InterviewingEvent> getlistOfInterviewingEvents(){
		return interviewingEvents;
	}
	
	public void addInterviewingEvent(InterviewingEvent event){
		interviewingEvents.add(event);
	}
	
	public Document getContract(){
		return contract;
	}
	
	public void setContract(Document contract){
		this.contract = contract;
	}

}
