import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Candidate extends Person{
  //Attributes
		//Events
		protected RecruitingEvent recruitingEvent;
		protected LinkedList<InterviewingEvent> listOfInterviewingEvents;
		protected String resumeFileId;
	
	//Constructors
		public Candidate(String first, String last, 
				GregorianCalendar update){
			super(first, last, update);
		}
		
		public Candidate(String inputFirst, String inputMiddle, String inputLast, 
				String inputMaiden, String inputPreferred, String inputEmail,
				String inputPhone, String inputStreetAddress, String inputCity,
				String inputState, String inputZipCode, String inputCountry, 
				String inputStatus, GregorianCalendar inputUpdateTime, 
				RecruitingEvent inputRecruitingEvent, LinkedList<InterviewingEvent> interviewingEvents){
			super(inputFirst, inputMiddle, inputLast, inputMaiden, inputPreferred,
					inputEmail, inputPhone, inputStreetAddress, inputCity,
					inputState, inputZipCode, inputCountry, inputStatus, 
					inputUpdateTime);
			recruitingEvent = inputRecruitingEvent;
			listOfInterviewingEvents = interviewingEvents;
		}
	
	//Methods
		//Events
    public RecruitingEvent getRecruitingEvent(){
    	return recruitingEvent;
    }
		
	public void setRecruitingEvent(RecruitingEvent event){
		recruitingEvent = event;
	}
	
	public LinkedList<InterviewingEvent> getInterviewingEvents(){
	    return listOfInterviewingEvents;
	}
	
	public void addInterviewingEvent(InterviewingEvent event){
		listOfInterviewingEvents.add(event);
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		String value;
		
		str.append(firstName);
		str.append(middleName);
		str.append(lastName);
		str.append(maidenName);
		str.append(preferredName);
		str.append(email);
		str.append(phone);
		str.append(streetAddress);
		str.append(city);
		str.append(state);
		str.append(zipCode);
		str.append(country);
		str.append(status);
		str.append(updateTime);
		
		value = str.toString();
		
		
		return value;
	}
}
