package model.person;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import model.person.Person.PersonType;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper{

	@Override
	public Person mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Person person = new Person();
		
		person.setId(rs.getInt("id"));
		person.setFirstName(rs.getString("firstName"));
		person.setMiddleName(rs.getString("middleName"));
		person.setLastName(rs.getString("lastName"));
		person.setMaidenName(rs.getString("maidenName"));
		person.setPreferredName(rs.getString("preferredName"));
		person.setUpdateTime(dateToCalendar(rs.getDate("updateTime")));
		person.setInsertTime(dateToCalendar(rs.getDate("insertTime")));
		person.setType(PersonType.valueOf(rs.getString("type")));
		person.setEmail(rs.getString("email"));
		person.setPhone(rs.getString("phone"));
		person.setStreetAddress(rs.getString("streetAddress"));
		person.setCity(rs.getString("city"));
		person.setState(rs.getString("state"));
		person.setZip(rs.getString("zip"));
		person.setCountry(rs.getString("country"));
		person.setDocument_id(rs.getInt("document_id"));
		person.setRecruitingEvent_id(rs.getInt("recruitingEvent_id"));
		person.setStatus(rs.getString("status"));
		
		return person;
	}
	
	protected static Calendar dateToCalendar(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

}
