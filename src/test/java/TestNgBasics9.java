import org.testng.Assert;
import org.testng.annotations.*;

//check execution flow after giving many test annotation and mention some priority and groups .

public class TestNgBasics9 {
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
    @Test(priority = 3,groups = "login") //5
    public void titleTest(){
        System.out.println("lg@titleTest1 and p3 -  check title of yor app");
    }
    @Test(priority = 1,groups = "registration")
    public void titleTest2(){
        System.out.println("rg@titleTest2 and p1 -  check title of yor app");
    }
    @Test(groups = "login")
    public void titleTest3(){
        System.out.println("lg@titleTest3 and p0 by default-  check title of yor app");
    }
    @Test(priority = 2,groups = "registration")
    public void titleTest4(){
        System.out.println("rg@titleTest4 and p2 -  check title of yor app");
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


