package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;


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
		 assertNotEquals("sss", cal.toString());

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
         assertNotEquals("ssa", cal.toString());

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

			CalDay c1 = new CalDay(new GregorianCalendar(2010, 1, 5));
			assertNotEquals(null, c1.toString());
			c1.addAppt(new Appt(2, 1, 1, 6, 2010, "a", "b"));
			assertNotEquals(null, c1.toString());
		}

		@Test
        public void test_calday_impr() throws Throwable {
            CalDay c = new CalDay(new GregorianCalendar(2010, 6, 10));
            assertEquals(2010, c.getYear());
            assertEquals(6, c.getMonth());
            assertEquals(10, c.getDay());

            Appt a1 = new Appt(2, 1, 1, 6, 2010, "a", "b");
            c.addAppt(a1);
            assertEquals(2, c.getAppts().get(0).getStartHour());
            assertEquals(1, c.getAppts().get(0).getStartMinute());

            Appt a2 = new Appt(1, 0, 1, 6, 2010, "a", "b");
            c.addAppt(a2);
            assertEquals(2, c.getAppts().get(1).getStartHour());
            assertEquals(1, c.getAppts().get(1).getStartMinute());
            assertEquals(1, c.getAppts().get(0).getStartHour());

            Appt a3 = new Appt(1, 77, 1, 6, 2010, "a", "b");
            c.addAppt(a3);
            assertNotEquals(3, c.getAppts().size());

            Appt a4 = new Appt(5, 1, 1, 6, 2010, "a", "b");
            c.addAppt(a4);
            assertEquals(5, c.getAppts().get(2).getStartHour());
            assertEquals(3, c.getAppts().size());

            Appt a5 = new Appt(-1, 1, 1, 6, 2010, "a", "b");
            c.addAppt(a5);
            assertEquals(3, c.getAppts().size());

            Appt a6 = new Appt(5, 6, 1, 6, 2010, "a", "b");
            c.addAppt(a6);
            assertEquals(6, c.getAppts().get(3).getStartMinute());
        }
}
