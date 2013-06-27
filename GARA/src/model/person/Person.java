package model.person;

import model.*;
import model.document.*;
import model.entity.*;
import model.interviewingEvent.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.util.Calendar;

public class Person{
	//Constants
	public enum PersonType{
		CANDIDATE, EMPLOYEE, RECRUITER
	}
	
	//Attributes
	protected Integer id; 
	protected String firstName; 
	protected String middleName; 
	protected String lastName; 
	protected String maidenName; 
	protected String preferredName; 
	protected Calendar updateTime; 
	protected Calendar insertTime;
	protected PersonType type; 
	protected String email; 
	protected String phone; 
	protected String streetAddress; 
	protected String city; 
	protected String state; 
	protected String zip; 
	protected String country; 
	protected Integer doc_id;
	protected Integer recruitingEvent_id;
	protected String status; 
		
	//Constructors
		public Person(Integer id, String firstName, String middleName, String lastName, 
				String maidenName, String preferredName, Calendar updateTime, 
				Calendar insertTime, PersonType type, String email,
				String phone, String streetAddress, String city,
				String state, String zip, String country, 
				Integer doc_id, Integer recruitingEvent_id,
				String status){
			this.id = id;
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.maidenName = maidenName;
			this.preferredName = preferredName;
			this.updateTime = updateTime;
			this.insertTime = insertTime;
			this.type = type;
			this.email = email;
			this.phone = phone;
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.country = country;
			this.doc_id = doc_id;
			this.recruitingEvent_id = recruitingEvent_id;
			this.status = status;
			
		}
		
	public Person() {
			// TODO Auto-generated constructor stub
		}

		//Methods
		public Integer getId(){
			return id;
		}
		
		public void setId(Integer id){
			this.id = id;
		}
		
		public String getFirstName(){
			return firstName;
		}
		
		public void setFirstName(String input){
			this.firstName = input;
		}
		
		public String getMiddleName(){
			return middleName;
		}
		
		public void setMiddleName(String input){
			this.middleName = input;
		}
		
		public String getLastName(){
			return lastName;
		}
		
		public void setLastName(String input){
			this.lastName = input;
		}
		
		public String getMaidenName(){
			return maidenName;
		}
		
		public void setMaidenName(String input){
			this.maidenName = input;
		}
		
		public String getPreferredName(){
			return preferredName;
		}
		
		public void setPreferredName(String input){
			this.preferredName = input;
		}
		
		public Calendar getUpdateTime(){
			return updateTime;
		}
		
		public void setUpdateTime(Calendar updateTime){
			this.updateTime = updateTime;
		}
		
		public Calendar getInsertTime(){
			return insertTime;
		}
		
		public void setInsertTime(Calendar insertTime){
			this.insertTime = insertTime;
		}
		
		public PersonType getType() {
			return type;
		}
		
		public void setType(PersonType type) {
			this.type = type;
		}
		
			//Information
		public String getEmail(){
			return email;
		}
		
		public void setEmail(String input){
			this.email = input;
		}
		
		public String getPhone(){
			return phone;
		}
		
		public void setPhone(String input){
			this.phone = input;
		}
		
		public String getStreetAddress(){
			return streetAddress;
		}
		
		public void setStreetAddress(String input){
			this.streetAddress = input;
		}
		
		public String getCity(){
			return city;
		}
		
		public void setCity(String input){
			this.city = input;
		}
		
		public String getState(){
			return state;
		}
		
		public void setState(String input){
			this.state = input;
		}
	 
		public String getZip(){
			return zip;
		}
		
		public void setZip(String zip){
			this.zip = zip;
		}
		
		public String getCountry(){
			return country;
		}
		
		public void setCountry(String input){
			this.country = input;
		}
		
		public String getStatus(){
			return status;
		}
		
		public void setStatus(String input){
			this.status = input;
		}

		public Integer getDocument_id() {
			return doc_id;
		}
		
		public void setDocument_id(Integer doc_id) {
			this.doc_id = doc_id;
		}

		public Integer getRecruitingEvent_id() {
			return recruitingEvent_id;
		}
		
		public void setRecruitingEvent_id(Integer recruitingEvent_id) {
			this.recruitingEvent_id = recruitingEvent_id;
		}




}
