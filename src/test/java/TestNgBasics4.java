import org.testng.Assert;
import org.testng.annotations.*;

//testng program using Assert class

public class TestNgBasics4 {
    @BeforeSuite //1
    public void setUp(){
        System.out.println("@BeforeSuite - Setting System Properties ");
    }
    @BeforeTest //2
    public void launchBrowser(){
        System.out.println("@BeforeTest - Launch Browser");
    }
    @BeforeClass //3
    public void enterUrl(){
        System.out.println("@BeforeClass - Enter Url");
    }
    @BeforeMethod //4
    public void login(){
        System.out.println("@BeforeMethod - login to app");
    }
    @Test //5
    public void titleTest(){
        int a= 2;
        int b = 3;
        int c = a + b;
        Assert.assertEquals(c,4);
    }
    @Test
    public void nextTestMethod(){
        boolean b = false;
        Assert.assertTrue(b);
    }
    @AfterMethod //6
    public void logout(){
        System.out.println("@AfterMethod - logout from app");
    }
    @AfterClass //7
    public void deleteAllCookies() {
        System.out.println("@AfterClass - Delete all cookies ");
    }
    @AfterTest //8
    public void closeBrowser() {
        System.out.println("@AfterTest - close the browser ");
    }
    @AfterSuite //9
    public void generateReport(){
        System.out.println("@AfterSuite - Generate Test Report");
    }
}
