package model.person;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;

public class PersonRowMapperTest {
	
	PersonRowMapper prm = new PersonRowMapper();

	@Test
	public void testDateToCalendar() {
		Date date = new Date(0);
		Calendar cal = prm.dateToCalendar(date);
		assertEquals(date, cal.getTime());
	}

}
