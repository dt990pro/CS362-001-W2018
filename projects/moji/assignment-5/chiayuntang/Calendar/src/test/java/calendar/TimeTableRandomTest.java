package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
         GregorianCalendar st = new GregorianCalendar(2018, 1, 1);
         GregorianCalendar ls = new GregorianCalendar(2018, 4, 20);
         LinkedList<Appt> appts = new LinkedList<Appt>();
         TimeTable ta = new TimeTable();

         long randomseed =System.currentTimeMillis(); //10
         //			System.out.println(" Seed:"+randomseed );
         Random random = new Random(randomseed);

         for(int i = 0; i < 100; i++){
             int startHour=ValuesGenerator.RandInt(random);
             int startMinute=ValuesGenerator.RandInt(random);
             int startDay=ValuesGenerator.RandInt(random);;
             int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
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

             appts.add(appt);
         }

         ta.getApptRange(appts, st, ls);
	 }

    @Test
    public void radnomtest_delete()  throws Throwable  {
        LinkedList<Appt> appts = new LinkedList<Appt>();
        TimeTable ta = new TimeTable();

        ta.deleteAppt(appts, new Appt(2,2,2,2,2,"aaa", "bbb"));

        long randomseed =System.currentTimeMillis(); //10
        //			System.out.println(" Seed:"+randomseed );
        Random random = new Random(randomseed);

        for(int i = 0; i < 100; i++){
            int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 3);
            int startMinute=1;
            int startDay=1;
            int startMonth=3;
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

            appts.add(appt);
        }

        for(int i = 0; i < 40; i+=2){
            ta.deleteAppt(appts, appts.get(i));
        }

        ta.deleteAppt(null, null);
        ta.deleteAppt(appts, null);

        System.out.print(appts.size());
    }
	
}
