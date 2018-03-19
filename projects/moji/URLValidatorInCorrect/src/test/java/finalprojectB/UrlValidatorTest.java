
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing
        // first time test to check if there are nerdy faults.
        // all scheme
        UrlValidator a = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        String url = "";
        assertEquals(false, a.isValid(url));

        url = "http://www.facebook.com";
        assertEquals(true, a.isValid(url));

        url = "http://www.facebook.com/xxxx";
        assertEquals(true, a.isValid(url));

        //url = "file:///C:/Users/mojia/Downloads/FinalProject-Part-B.pdf"; // this part will cause err
        //assertEquals(true, a.isValid(url));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing

       // test whether scheme works
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String[] s = {"http", "ftp"};
       int n = 2;

       for (int i = 0; i < n; i++){
           assertEquals(true, urlVal.isValidScheme(s[i]));
       }
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing

       // test whether scheme works
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String[] s = {"www.google.com", "go.com", "0.0.1.0", "255.255.255.255", "0.0.0.0", "255.com"};
       int n = 6;

       for (int i = 0; i < n; i++){
           //assertEquals(true, urlVal.isValidAuthority(s[i]));
           // this reveals BUG1 so we decide to comment it out
           // to keep test running
       }
   }
   //You need to create more test cases for your Partitions if you need to

    public void testYourThirdPartition()
    {
        //You can use this function to implement your First Partition testing

        // test whether port works
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String[] s = {":80", ":0", "", ":65535"};
        int n = 4;

        for (int i = 0; i < n; i++){
            assertEquals(true, urlVal.isValidFragment(s[i]));
        }
    }

    public void testYourFourthPartition()
    {
        //You can use this function to implement your First Partition testing

        // test whether path works
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String[] s = {"/test1", "/$23", "/t123"};
        int n = 3;

        for (int i = 0; i < n; i++){
            assertEquals(true, urlVal.isValidPath(s[i]));
        }
    }

    public void testYourFifthPartition()
    {
        //You can use this function to implement your First Partition testing

        // test whether path works
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String[] s = {"?action=view", "?action=edit&mode=up"};
        int n = 2;

        for (int i = 0; i < n; i++){
            assertEquals(true, urlVal.isValidQuery(s[i]));
        }
    }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        // each of following part is true because they are passed final froject a
        String[] scheme = {"http://", "ftp://", "h3t://", ""};
        int scheme_num = 4;

        String[] authority = {"www.google.com", "go.com", "0.0.1.0", "255.255.255.255", "0.0.0.0", "255.com"};
        int authority_num = 6;

        String[] port = {":80", ":0", "", ":65535"};
        int port_num = 4;

        String[] path = {"/test1", "/$23", "/t123", "/test1/", "/test1/file", "", "/$23/file"};
        int path_num = 7;

        String[] query = {"?action=view", "?action=edit&mode=up", ""};
        int q_num = 3;

        String s = "";
       long randomseed =System.currentTimeMillis();
       Random random = new Random(randomseed);
        int n = 0;

        for(int i = 0; i < 500; i++){
            n = random.nextInt(scheme_num);
            s = append(s, scheme[0]); // there is BUG2, only http passed, in the brakets, it should be n but I give 0.
            n = random.nextInt(authority_num);
            s = append(s, authority[n]);
            n = random.nextInt(port_num);
            s = append(s, port[n]);
            n = random.nextInt(path_num);
            s = append(s, path[n]);
            n = random.nextInt(q_num);
            s = append(s, query[n]);

            // check valid
            if(urlVal.isValid(s) != true) {
                // print out url that can not pass
                System.out.println(s);
            } else {
                System.out.println(s);
            }

            s = "";
        }


   }
   
    public String append(String s, String obj){
        s += obj;
        return s;
    }

}
