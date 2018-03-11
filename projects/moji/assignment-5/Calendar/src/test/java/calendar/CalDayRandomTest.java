package calendar;


import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
         GregorianCalendar cal = new GregorianCalendar(2010, 10, 31);
         CalDay ca = new CalDay((GregorianCalendar) cal);

         long randomseed =System.currentTimeMillis(); //10
         //			System.out.println(" Seed:"+randomseed );
         Random random = new Random(randomseed);

         for(int i = 0; i < 1000; i++){
             int startHour=ValuesGenerator.RandInt(random);
             int startMinute=ValuesGenerator.RandInt(random);
             int startDay=ValuesGenerator.RandInt(random);;
             int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
             int startYear=ValuesGenerator.RandInt(random);
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

             ca.addAppt(appt);
         }
		 
	 }


	
}
