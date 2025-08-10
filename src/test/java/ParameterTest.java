import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterTest {
    WebDriver driver;
    @BeforeSuite
    public void abc(){
        System.out.println("Setup");
    }

//    @BeforeSuite
    @Test
    @Parameters({"browser"}) //@Parameters({"parameter_name within testing.xml"})
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
    }

    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"Google","Title does not match");
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
