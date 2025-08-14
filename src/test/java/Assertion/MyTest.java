//Hard and soft assertion

package Assertion;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTest {
    SoftAssert softAssert1 = new SoftAssert(); //soft assertion
    @Test
    public void test1() {

        System.out.println("Open Browser");
        System.out.println("Enter URL");
        Assert.assertEquals(true, true);
        System.out.println("Enter Username");
        System.out.println("Enter Password");
        System.out.println("Click on Sign in button");
        Assert.assertEquals(true, true);
        System.out.println("Validate Home page");
//        Assert.assertEquals(true,false);  //hard assertion  (come when mismatch case)
        softAssert1.assertEquals(false, true); //soft assertion
        System.out.println("Go to Deals page");
        System.out.println("Create a deal");
        softAssert1.assertEquals(false, true);
        System.out.println("Go to Contacts page");
        System.out.println("Create a contact");
        softAssert1.assertEquals(false, true);
        System.out.println("Logout");
        System.out.println("Close browser");
        softAssert1.assertAll();  //it tracks when and where all the soft assertion failed and stores all the information in a stack
    }

    @Test
    public void test2() {
        SoftAssert softAssert2 = new SoftAssert();
        System.out.println("Delete all cookies");
        softAssert2.assertEquals(true,false);
        softAssert2.assertAll(); // we write this in last line of our program because if we write middle of the program then we can't execute further means when this line executes it gives AssertionError and our test failed.
    }

//    @AfterClass
//    public void tearDown(){
//        softAssert1.assertAll();
//    }
    /*
    RESULT OF OUTPUT OF ABOVE PROGRAM
    ------------------------
    when softAssert reference is one
     Default Suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
Configuration Failures: 1, Skips: 0
test1 , test2 - pass
tearDown - fail
     */
}
//when we write assertAll() method within one @test annotation then it gives all failure assertions lines and why they fail.


