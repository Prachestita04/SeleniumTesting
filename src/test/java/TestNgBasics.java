import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgBasics {
    @BeforeSuite
    public void setup(){
        System.out.println("Setup");
    }
    @Test
    public void login(){
        System.out.println("Login");
    }
    @AfterSuite
    public void logout(){
        System.out.println("Logout");
    }
}
