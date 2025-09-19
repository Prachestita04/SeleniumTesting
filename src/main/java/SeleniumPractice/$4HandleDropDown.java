package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;

public class $4HandleDropDown {
    static String baseurl = "https://www.facebook.com/r.php?entry_point=login";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement searchFirstName = driver.findElement(By.name("firstname"));
        searchFirstName.sendKeys("Mamuni");
        WebElement searchLastName = driver.findElement(By.name("lastname"));
        searchLastName.sendKeys("Mahapatra");
        System.out.println("Successfully typed firstname and lastname");

        WebElement dateDropDown = driver.findElement(By.id("day"));
        Select date = new Select(dateDropDown);
        date.selectByVisibleText("15");
        System.out.println("Date selection is done successfully");

        WebElement monthDropDown = driver.findElement(By.id("month"));
        Select month = new Select(monthDropDown);
        month.selectByVisibleText("Feb");
        System.out.println("Month is selected successfully");

        WebElement yearDropDown = driver.findElement(By.id("year"));
        Select year = new Select(yearDropDown);
        year.selectByVisibleText("1999");
        System.out.println("Year is selected successfully");

        Thread.sleep(3000);
        driver.quit();
    }
}
