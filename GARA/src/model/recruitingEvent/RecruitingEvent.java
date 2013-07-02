package model.recruitingEvent;

import model.document.*;
import model.entity.*;
import model.person.*;
import java.util.Calendar;
import java.util.List;

public class RecruitingEvent {
	public enum RecruitingEventType{
		CAREER_FAIR, REFERRAL, RESUME_DUMP, WEBSITE
	}
	
	//Attributes
	protected Integer id;
	protected Calendar updateTime;
	protected Calendar insertTime; 
	protected Calendar eventDateTime; 
	protected RecruitingEventType type;
	protected Integer entity_id;
	protected Integer description_id;
	protected String streetAddress;
	protected String city;
	protected String state;
	protected String zip;
	protected String country;
	protected Entity entity; 
	protected Document description;
	protected List<Employee> attendees;
	
	//Constructors
	public RecruitingEvent(Integer id, 
			Calendar updateTime, Calendar insertTime, Calendar eventDateTime, 
			RecruitingEventType type, Integer entity_id, Integer description_id, 
			String streetAddress, String city, String state, String zip, String country,
			Entity entity, Document description,
			List<Employee> attendees){
		this.id = id;
		this.updateTime = updateTime;
		this.insertTime = insertTime;
		this.eventDateTime = eventDateTime;
		this.type = type;
		this.entity_id = entity_id;
		this.description_id = description_id;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.entity = entity;
		this.description = description;
		this.attendees = attendees;
	}
	
	//Methods
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	public Calendar getEventDateTime(){
		return eventDateTime;
	}
	
	public void setEventDateTime(Calendar eventDateTime){
		this.eventDateTime = eventDateTime;
	}

	public Calendar getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Calendar updateTime){
		this.updateTime = updateTime;
	}
	
	public RecruitingEventType getType(){
		return type;
	}
	
	public void setType(RecruitingEventType type){
		this.type = type;
	}
	
	public List<Employee> getAttendees(){
		return attendees;
	}
	
	public void addAttendee(Employee emp){
		this.attendees.add(emp);
	}

	

}
