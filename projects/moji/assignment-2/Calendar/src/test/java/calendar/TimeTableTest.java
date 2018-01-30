package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		TimeTable t = new TimeTable();

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

		 startHour=20;
		 //Construct a new Appointment object with the initial data
		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour=22;
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour=29;
		 //Construct a new Appointment object with the initial data
		 Appt appt3 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour=27;
		 //Construct a new Appointment object with the initial data
		 Appt appt4 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt4.setRecurrence(new int[0], 2, 0, 3);

		 startHour=20;
		 startDay=22;
		 //Construct a new Appointment object with the initial data
		 Appt appt5 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt5.setRecurrence(new int[0], 2, 0, 3);

		 LinkedList<Appt> as = new LinkedList<Appt>();
		 as.add(0, appt);
		 as.add(1, appt1);
		 as.add(2, appt2);
		 as.add(3, appt3);
		 as.add(4, appt4);
		 as.add(5, appt5);

		 GregorianCalendar st = new GregorianCalendar(2018, 1, 1);
		 GregorianCalendar ls= new GregorianCalendar(2018, 1, 20);


		 assertEquals(false, t.getApptRange(as, st, ls).contains(appt));
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=30;
		 int startMinute=30;
		 int startDay=18;
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
		 appt.setRecurrence(new int [0], 1, 0, 3);

		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt1.setRecurrence(new int [0], 3, 0, 3);

		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt2.setRecurrence(new int [2], 1, 0, 3);

		 TimeTable ta = new TimeTable();
		 LinkedList<Appt> ats = new LinkedList<Appt>();

		 GregorianCalendar st = new GregorianCalendar(2018, 1, 1);
		 GregorianCalendar ls = new GregorianCalendar(2018, 1, 20);

		 ats.add(0, appt);
		 ats.add(1, appt1);
		 ats.add(2, appt2);
		 ta.getApptRange(ats, st, ls);
	 }
//add more unit tests as you needed
	@Test
	public void test03()  throws Throwable  {
		TimeTable ta = new TimeTable();
		assertEquals(null, ta.deleteAppt(null, null));

		int startHour=30;
		int startMinute=30;
		int startDay=18;
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

		assertEquals(null, ta.deleteAppt(new LinkedList<Appt>(), appt));
	}

	@Test
	public void test04()  throws Throwable  {
		int startHour=20;
		int startMinute=30;
		int startDay=18;
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

		TimeTable ta = new TimeTable();
		assertEquals(null, ta.deleteAppt(new LinkedList<Appt>(), appt));

		startHour=14;
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		startHour=16;
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		LinkedList<Appt> as = new LinkedList<Appt>();
		as.add(0, null);
		as.add(1, appt);
		as.add(2, appt1);
		as.add(3, appt2);
		assertNotEquals(null, ta.deleteAppt(as, appt));
		assertEquals(null, ta.deleteAppt(as, null));
	}

	@Test
	public void test05()  throws Throwable  {
		int startHour=20;
		int startMinute=30;
		int startDay=18;
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

		TimeTable ta = new TimeTable();
		assertEquals(null, ta.deleteAppt(new LinkedList<Appt>(), appt));

		startHour=14;
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		startHour=16;
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		LinkedList<Appt> as = new LinkedList<Appt>();
		as.add(0, null);
		as.add(1, appt);
		as.add(2, appt1);
		as.add(3, appt2);

		int[] pv = new int[4];
		assertNotEquals(null, ta.permute(as, pv));
	}
}
