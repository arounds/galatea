package model.entity;

import model.person.*;


import java.util.Calendar;

public class Entity {
	//Attributes
	protected Integer id;
		protected String name;
		protected Calendar updateTime;
		protected Calendar insertTime;
		protected String type;
		protected Integer contact_id;
		protected String website;
		protected String streetAddress;
		protected String city;
		protected String state;
		protected String zipCode;
		protected String country;
		protected String status;
		protected Recruiter contact;
	//Constructors
		public Entity(String name, String type, String website, 
				Recruiter contact,
				String streetAddress, String city, 
				String state, String zipCode, String country,
				String status, Calendar updateTime){
			this.name = name;
			this.type = type;
			this.website = website;
			this.contact = contact;
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.country = country;
			this.status = status;
			this.updateTime = updateTime;
		}
		
	//Methods
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public String getType(){
			return type;
		}
		
		public void setType(String type){
			this.type = type;
		}
		
		public String getWebsite(){
			return website;
		}
		
		public void setWebsite(String website){
			this.website = website;
		}
		
		public Recruiter getContact(){
			return contact;
		}
		
		public void setContact(Recruiter contact){
			this.contact =  contact;
		}
		
		public String getStreetAddress(){
			return streetAddress;
		}
		
		public void setStreetAddress(String streetAddress){
			this.streetAddress = streetAddress;
		}
		
		public String getCity(){
			return city;
		}
		
		public void setCity(String city){
			this.city = city;
		}
		
		public String getState(){
			return state;
		}
		
		public void setState(String state){
			this.state = state;
		}
	 
		public String getZipCode(){
			return zipCode;
		}
		
		public void setZipCode(String zipCode){
			this.zipCode = zipCode;
		}
		
		public String getCountry(){
			return country;
		}
		
		public void setCountry(String country){
			this.country = country;
		}
		
		public String getStatus(){
			return status;
		}
		
		public void setStatus(String status){
			this.status = status;
		}
		
		public Calendar getUpdateTime(){
			return updateTime;
		}

}
