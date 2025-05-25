package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropDowns {
    private static final String driverTpe = "webdriver.edge.driver";
    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://www.facebook.com/r.php?entry_point=login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(driverTpe, driverLocation);
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
        Select selectDate = new Select(dateDropDown);
        selectDate.selectByVisibleText("15");
        System.out.println("Successfully select date");

        WebElement monthDropDown = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDropDown);
        selectMonth.selectByVisibleText("Feb");
        System.out.println("Successfully select month");

        WebElement yearDropDown = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDropDown);
        selectYear.selectByVisibleText("1999");
        System.out.println("Successfully select year");
        Thread.sleep(10000);


        driver.quit();
    }
}
