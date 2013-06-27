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

public class Candidate extends Person{
	//Attributes
		//Events
		protected RecruitingEvent recruitingEvent;
		protected List<InterviewingEvent> interviewingEvents;
		protected Document resume;
	
	//Constructors		
		public Candidate(
				Integer id, 
				String firstName, 
				String middleName, 
				String lastName, 
				String maidenName, 
				String preferredName, 
				Calendar updateTime, 
				Calendar insertTime, 
				PersonType type, 
				String email,
				String phone, 
				String streetAddress, 
				String city,
				String state, 
				String zip, 
				String country, 
				String status, 
				RecruitingEvent recruitingEvent, 
				List<InterviewingEvent> interviewingEvents, 
				Document resume){
			super(id, firstName, middleName, lastName, maidenName, preferredName, 
					updateTime, insertTime,
					type, email, phone, 
					streetAddress, city, state, zip, country, 
					resume.getId(), recruitingEvent.getId(), status);
			this.recruitingEvent = recruitingEvent;
			this.interviewingEvents = interviewingEvents;
			this.resume = resume;
		}
	
	public Candidate() {}

	//Methods
		//Events
    public RecruitingEvent getRecruitingEvent(){
    	return recruitingEvent;
    }
		
	public void setRecruitingEvent(RecruitingEvent event){
		recruitingEvent = event;
	}
	
	public List<InterviewingEvent> getInterviewingEvents(){
		return interviewingEvents;
	}
	
	public void addInterviewingEvent(InterviewingEvent event){
		interviewingEvents.add(event);
	}
	
	public Document getDocument(){
		return resume;
	}
	
	public void setDocument(Document resume){
		this.resume = resume;
	}
	
}
