package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		CalDay c = new CalDay();
		assertEquals(false, c.valid);
		GregorianCalendar cal = new GregorianCalendar(2010, 10, 31);
		CalDay ca = new CalDay((GregorianCalendar) cal);
		assertEquals(true, ca.valid);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 GregorianCalendar c = new GregorianCalendar(appt.getStartYear(), appt.getStartMonth(), appt.getStartDay());
		 CalDay cal = new CalDay(c);
		 cal.addAppt(appt);

		 startHour=20;
		 //Construct a new Appointment object with the initial data
		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cal.addAppt(appt1);

		 startHour=22;
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cal.addAppt(appt2);

		 startHour=21;
		 //Construct a new Appointment object with the initial data
		 Appt appt3 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cal.addAppt(appt3);

		 startHour=27;
		 //Construct a new Appointment object with the initial data
		 Appt appt4 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cal.addAppt(appt4);


		 //assertions
		 assertEquals(true, cal.isValid());
		 assertNotEquals(null, cal.iterator());
		 assertNotEquals("sss", cal.toString());
		 assertNotEquals(0, cal.getSizeAppts());
	 }
//add more unit tests as you needed
		@Test
		public void test03()  throws Throwable  {
			CalDay c = new CalDay();
			assertNotEquals(null, c.toString());
			assertEquals(null, c.iterator());


		}
}
