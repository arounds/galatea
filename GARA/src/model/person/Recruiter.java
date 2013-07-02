package model.person;

import java.util.Calendar;


public class Recruiter extends Person{

	public Recruiter(Integer id, String firstName, String middleName, String lastName, 
			String maidenName, String preferredName, Calendar updateTime, 
			Calendar insertTime, PersonType type, String email,
			String phone, String streetAddress, String city,
			String state, String zip, String country, 
			String status) {
		super(id, firstName, middleName, lastName, maidenName, preferredName, 
				updateTime, insertTime,
				type, email, phone, 
				streetAddress, city, state, zip, country, 
				null, null, status);
	}



}
