package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleMouseMovement {
    private static final String driverType = "webdriver.edge.driver";
    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://demowebshop.tricentis.com/tricentis";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(driverType, driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement hoverComputer = driver.findElement(By.xpath("(//a[@href = '/computers'])[1]"));
        WebElement hoverAccessories = driver.findElement(By.xpath("(//a[@href = '/accessories'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverComputer).build().perform();
        hoverAccessories.click();
//        hoverComputer.click();
        System.out.println("Successfully hovered and clicked");
        Thread.sleep(5000);
        driver.quit();
    }
}
