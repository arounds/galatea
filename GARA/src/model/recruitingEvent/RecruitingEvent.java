package model.recruitingEvent;

import model.*;
import model.document.*;
import model.entity.*;
import model.person.*;
import model.interviewingEvent.*;
import model.schedulingEntry.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import com.google.cloud.sql.jdbc.CallableStatement;
import com.google.cloud.sql.jdbc.ResultSet;

public class RecruitingEvent {
	//Attributes
	protected Calendar eventDate;
	protected Calendar updateTime;
	protected String type;
	protected String entityName;
	protected String streetAddress;
	protected String city;
	protected String state;
	protected String zipCode;
	protected String country;
	protected List<Employee> listOfAttendees;
	
	//Constructors
	public RecruitingEvent(Calendar eventDate, 
			Calendar updateTime,
			String type, String entityName, 
			String streetAddress, String city, String state, String zipCode, String country,
			List<Employee> listOfAttendees){
		this.eventDate = eventDate;
		this.updateTime = updateTime;
		this.type = type;
		this.entityName = entityName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.listOfAttendees = listOfAttendees;
	}
	
	//Methods
	
	public Calendar getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(Calendar eventDate){
		this.eventDate = eventDate;
	}

	public Calendar getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Calendar updateTime){
		this.updateTime = updateTime;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String input){
		type = input;
	}
	
	public List<Employee> getListOfAttendees(){
		return listOfAttendees;
	}
	
	public void addAttendee(Employee emp){
		listOfAttendees.add(emp);
	}

	

}
