package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=10;
		 int startMinute=10;
		 int startDay=10;
		 int startMonth=10;
		 int startYear=2000;
		 String title="lalalalalala";
		 String description="ahhhhhhhhhhh";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 //assertions
		 appt.setStartHour(11);
		 appt.setStartMinute(12);
		 appt.setStartDay(13);
		 appt.setStartMonth(9);
		 appt.setStartYear(2009);
		 appt.setTitle("yyy");
		 appt.setDescription("sss");
		 assertEquals(11, appt.getStartHour());
		 assertEquals(12, appt.getStartMinute());
		 assertEquals(13, appt.getStartDay());
		 assertEquals(9, appt.getStartMonth());
		 assertEquals(2009, appt.getStartYear());
		 assertEquals("yyy", appt.getTitle());
		 assertEquals("sss", appt.getDescription());

		 //assertions
		 assertEquals(0, appt.getRecurNumber());
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurDays().length);

		 //assertions


	 }
//add more unit tests as you needed
	  @Test
	  public void test03() throws Throwable {
		  int startHour=29;
		  int startMinute=30;
		  int startDay=15;
		  int startMonth=2;
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

		  Appt appt_1 = new Appt(startHour,
				  startMinute ,
				  startDay ,
				  startMonth ,
				  startYear ,
				  title,
				  description);

		  //assertions
		  assertNotEquals("sss", appt.toString());
		  assertEquals(appt.toString(), appt_1.toString());
		  assertEquals(0, appt.compareTo(appt));
	  }

	@Test
	public void test04() throws Throwable {
		int startHour=6;
		int startMinute=99;
		int startDay=99;
		int startMonth=2;
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

		assertEquals(false, appt.getValid());
	}

	@Test
	public void test05() throws Throwable {
		int startHour=6;
		int startMinute=9;
		int startDay=99;
		int startMonth=2;
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

		assertEquals(false, appt.getValid());

		appt.setStartHour(0);
		assertNotEquals("sss", appt.toString());
		appt.setDescription(null);
		assertEquals("", appt.getDescription());
		appt.setTitle(null);
		assertEquals("", appt.getTitle());
		assertEquals(false, appt.isRecurring());
		assertEquals(0, appt.getRecurIncrement());
		assertNotEquals(99, appt.getRecurIncrement());
		appt.setRecurrence(null, 0, 0, 0);

		appt.setRecurrence(new int[5], 0, 3, 3);
		assertEquals(5, appt.getRecurDays().length);
		assertEquals(3, appt.getRecurIncrement());
		assertEquals(3, appt.getRecurNumber());
	}

    @Test
    public void test_isValid_impr() throws Throwable {
        int startHour=0;
        int startMinute=0;
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


        appt.setStartHour(-1);
        assertEquals(false, appt.getValid());
        appt.setStartHour(0);
        assertEquals(true, appt.getValid());
        appt.setStartHour(3);
        assertEquals(true, appt.getValid());
        appt.setStartHour(24);
        assertEquals(true, appt.getValid());

        appt.setStartMinute(-1);
        appt.setStartMinute(0);
        assertEquals(true, appt.getValid());
        appt.setStartMinute(-5);
        assertEquals(false, appt.getValid());
        appt.setStartMinute(5);
        assertEquals(true, appt.getValid());
        appt.setStartMinute(59);
        assertEquals(true, appt.getValid());

        appt.setStartDay(-2);
        assertEquals(false, appt.getValid());
        appt.setStartDay(1);
        assertEquals(true, appt.getValid());
        appt.setStartDay(31);
        assertEquals(true, appt.getValid());

        appt.setStartMonth(12);
        assertEquals(true, appt.getValid());

    }

    @Test
    public void test_toString_impr() throws Throwable {
        int startHour=21;
        int startMinute=30;
        int startDay=15;
        int startMonth=01;
        int startYear=2018;
        String title="a";
        String description="b";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        assertEquals(null, appt.toString());
        appt.setStartHour(-1);
        assertNotEquals(null, appt.toString());

        appt.setStartMinute(65);
        appt.setStartHour(11);
        assertEquals(11, appt.getStartHour());
        assertEquals("\t1/15/2018 at 11:65am ,a, b\n", appt.toString());
        appt.setStartHour(14);
        assertEquals(14, appt.getStartHour());
        assertEquals("\t1/15/2018 at 12:65pm ,a, b\n", appt.toString());
    }

    @Test
    public void test_compTo_impr() throws Throwable {
        Appt appt = new Appt(2, 1, 2, 1, 2000, "a", "b");
        Appt cappt = new Appt(1, 2, 1, 2, 2001, "a", "b");

        assertEquals(-1, appt.compareTo(cappt));
    }

}
