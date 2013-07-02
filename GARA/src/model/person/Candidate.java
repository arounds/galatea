package model.person;

import model.document.*;
import model.interviewingEvent.*;
import model.recruitingEvent.*;
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
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
	    result.append(" First Name: " + firstName + NEW_LINE);
	    result.append(" Middle Name: " + middleName + NEW_LINE);
	    result.append(" Last Name: " + lastName + NEW_LINE);
	    result.append(" Maiden Name: " + maidenName + NEW_LINE);
	    result.append(" Preferred Name: " + preferredName + NEW_LINE);
	    result.append(" Email: " + email + NEW_LINE);
	    result.append(" Phone: " + phone + NEW_LINE );
	    result.append(" Street Address: " + streetAddress + NEW_LINE);
	    result.append(" City: " + city + NEW_LINE);
	    result.append(" State: " + state + NEW_LINE);
	    result.append(" Zip Code: " + zip + NEW_LINE);
	    result.append(" Country: " + country + NEW_LINE);
	    result.append(" Status: " + status + NEW_LINE);

	    //Note that Collections and Maps also override toString
	    result.append(" Recruiting Event: " + recruitingEvent + NEW_LINE);
	    result.append(" Interviewing Events: " + interviewingEvents + NEW_LINE);
	    result.append(" Resume: " + resume + NEW_LINE);
	    result.append("}");
	    
	    return result.toString();

	}
	
}
