import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
    }

    @Test(priority = 1)
    public void titleTest(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"Google","Title does not match");
    }

    @Test(priority = 2)
    public void logoTest(){
        boolean b = driver.findElement(By.xpath("//*[name()='svg' and  @class='lnXdpd']")).isDisplayed();
        Assert.assertTrue(b);
    }

    @Test(priority = 1)
    public void gmailLinkTest(){
//        boolean b = driver.findElement(By.className("gb_X")).isDisplayed();
        //boolean b = driver.findElement(By.xpath("//a[@aria-label = 'Gmai")).isDisplayed() ;
        //boolean b = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/&ogbl']")).isDisplayed() ;
        boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed() ;
        Assert.assertTrue(b);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
