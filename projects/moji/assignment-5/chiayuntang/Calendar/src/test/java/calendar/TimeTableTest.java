package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


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

		 // for inverse date
		 TimeTable t2 = new TimeTable();
		 t2.getApptRange(as, ls, st); // no err
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

    @Test
    public void test_getApprange_impr()  throws Throwable  {
        LinkedList<Appt> appts = new LinkedList<Appt>();
        GregorianCalendar st = new GregorianCalendar(2018, 1, 1);
        GregorianCalendar ls = new GregorianCalendar(2018, 1, 10);
        TimeTable tt = new TimeTable();

        //53
        tt.getApptRange(appts, st, ls);

        //55
        Appt a = new Appt(-5, 70, 2, 1, 2018, "a", "s");
        appts.add(a);
        Appt a1 = new Appt(2, 1, 2, 1, 2018, "a", "b");
        assertEquals(true, a1.getValid());
        appts.add(a1);
        Appt a3 = new Appt(5, 70, 5, 1, 2018, "a", "s");
        appts.add(a3);
        Appt a4 = new Appt(5, 70, 3, 1, 2018, "a", "s");
        appts.add(a4);
        Appt a5 = new Appt(5, 70, 10, 1, 2018, "a", "s");
        appts.add(a5);
        Appt a2 = new Appt(2, 77, 2, 1, 2000, "a", "b");
        assertEquals(false, a2.getValid());
        appts.add(a2);

        tt.getApptRange(appts, st, ls);
    }

    @Test
    public void test_getApptOcc_impr()  throws Throwable  {
        LinkedList<Appt> appts = new LinkedList<Appt>();
        GregorianCalendar st = new GregorianCalendar(2018, 1, 2);
        GregorianCalendar ls = new GregorianCalendar(2018, 1, 10);
        TimeTable tt = new TimeTable();

        Appt a = new Appt(5, 77, 4, 1, 2018, "a", "s");
        a.setRecurrence(new int[2], 0, 0, -1);
        assertEquals(-1, a.getRecurNumber());
        appts.add(a);

        Appt a1 = new Appt(5, 77, 5, 1, 2018, "a", "s");
        appts.add(a1);

        Appt a2 = new Appt(5, 77, 6, 1, 2018, "a", "s");
        appts.add(a2);
        a2.setRecurrence(null, 0, 0, 1);

        System.out.print("+++\n");
        tt.getApptRange(appts, st, ls);



    }

    @Test
    public void test_getApptOc_impr()  throws Throwable  {
        LinkedList<Appt> appts = new LinkedList<Appt>();
        TimeTable tt = new TimeTable();

        Random random = new Random();

        for(int i = 0; i < 20; i++){
            // add appt
            for(int j = 0; j < 50; j++){
                appts.add(new Appt(
                        random.nextInt(60) - 30,
                        random.nextInt(200) - 100,
                        random.nextInt(100) - 50,
                        random.nextInt(12) + 1,
                        random.nextInt(3) + 2000,
                        "a",
                        "b"));
            }

            // 0
            {
                for(int k = 0; k < 50; k++){
                    appts.get(k).setRecurrence(null, random.nextInt(3) + 1, random.nextInt(5)+0, random.nextInt(5)+0);
                }

                // add time range
                tt.getApptRange(
                        appts,
                        new GregorianCalendar(
                                2000,
                                random.nextInt(12) + 0,
                                random.nextInt(31) + 0),
                        new GregorianCalendar(
                                random.nextInt(2) + 2001,
                                random.nextInt(12) + 0,
                                random.nextInt(31) + 0)
                );

				int[] pv = new int[50];
				for(int m = 0; m < 50; m++){
				    pv[m] = m;
                }

                tt.permute(appts, pv);

                for(int l = 0; l < 10; l++){
                    int a = random.nextInt(100);
                    if(appts.size()-1 <= a) continue;
                    tt.deleteAppt(appts, appts.get(a));
                }
                tt = new TimeTable();
            }

            // 1
            {
                int[] a = {1};
                for(int k = 0; k < 40; k++){
                    appts.get(k).setRecurrence(a, random.nextInt(3) + 1, random.nextInt(5)+0, random.nextInt(5)+0);
                }

                // add time range
                tt.getApptRange(
                        appts,
                        new GregorianCalendar(
                                2000,
                                random.nextInt(12) + 0,
                                random.nextInt(31) + 0),
                        new GregorianCalendar(
                                random.nextInt(2) + 2001,
                                random.nextInt(12) + 0,
                                random.nextInt(31) + 0)
                );

                for(int l = 0; l < 10; l++){
                    int b = random.nextInt(100);
                    if(appts.size()-1 <= b) continue;
                    tt.deleteAppt(appts, appts.get(b));
                }
                tt = new TimeTable();
            }

            // 4
            {
                int[] a = {1, 2, 3, 4};
                for(int k = 0; k < 30; k++){
                    appts.get(k).setRecurrence(a, random.nextInt(3) + 1, random.nextInt(5)+0, random.nextInt(5)+0);
                }

                // add time range
                tt.getApptRange(
                        appts,
                        new GregorianCalendar(
                                2000,
                                random.nextInt(12) + 0,
                                random.nextInt(31) + 0),
                        new GregorianCalendar(
                                random.nextInt(2) + 2001,
                                random.nextInt(12) + 0,
                                random.nextInt(31) + 0)
                );

                for(int l = 0; l < 10; l++){
                    int c = random.nextInt(100);
                    if(appts.size()-1 <= c) continue;
                    tt.deleteAppt(appts, appts.get(c));
                }
                tt = new TimeTable();
            }

            appts.clear();
        }
    }
}
