import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterTest1 {
    WebDriver driver;

    @BeforeSuite
    public void abc() {
        System.out.println("Setup");
    }

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/r.php?entry_point=login");
    }

    @Test
    @Parameters({"firstname", "lastname", "date"})
    public void passFirstNameLastNameDate(String firstName, String lastName, int date) {
        WebElement firstNameBar = driver.findElement(By.name("firstname"));
        firstNameBar.clear();
        firstNameBar.sendKeys(firstName);
        WebElement lastNameBar = driver.findElement(By.name("lastname"));
        lastNameBar.clear();
        lastNameBar.sendKeys(lastName);
        WebElement dateBar = driver.findElement(By.id("day"));
        Select selectDateDropDown = new Select(dateBar);
        selectDateDropDown.selectByVisibleText(Integer.toString(date));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
