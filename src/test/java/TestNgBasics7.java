import org.testng.Assert;
import org.testng.annotations.*;

//check execution flow after giving many test annotation .

public class TestNgBasics7 {
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
        System.out.println("@titleTest1 -  check title of yor app");
    }
    @Test
    public void titleTest2(){
        System.out.println("@titleTest2 -  check title of yor app");
    }
    @Test
    public void titleTest3(){
        System.out.println("@titleTest3 -  check title of yor app");
    }
    @Test
    public void titleTest4(){
        System.out.println("@titleTest4 -  check title of yor app");
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

