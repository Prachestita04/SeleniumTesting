package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleKeyBoardMovement$1 {
//    private static final String driverType = "webdriver.edge.driver";
//    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://www.google.co.in/";

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty(driverType, driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement searchbar = driver.findElement(By.xpath("//textarea[@name = 'q']"));
        Actions actions = new Actions(driver);
        actions.
                keyDown(searchbar, Keys.SHIFT).
                sendKeys("facebook").
                keyUp(Keys.SHIFT).build().perform();

        Thread.sleep(10000);
        driver.quit();
    }
}
