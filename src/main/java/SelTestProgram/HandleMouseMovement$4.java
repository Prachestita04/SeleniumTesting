package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleMouseMovement$4 {
//    private static final String driverType = "webdriver.edge.driver";
//    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://www.flipkart.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        try {

//            System.setProperty(driverType, driverLocation);
            driver = new EdgeDriver();

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            driver.get(baseurl);
            WebElement fashionElement = driver.findElement(By.xpath("(//span[text()='Fashion']//parent::span)[2]"));
            Actions actions = new Actions(driver);
//            actions.
//                    moveToElement(fashionElement).perform();
            fashionElement.click();
            Thread.sleep(10000);

            WebElement menIconElement = driver.findElement(By.xpath("//span[text()='Men']"));
            actions.moveToElement(menIconElement).click().build().perform();
            WebElement topWearElement = driver.findElement(By.xpath("//a[@title='Top wear']"));
            WebElement shirtElement = driver.findElement(By.xpath("//a[text()='T-Shirts']"));
//            //a[contains(text(),'Top wear')]

            actions.
                    moveToElement(topWearElement).
                    moveToElement(shirtElement).click().build().perform();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("Error occurred during execution of code:"+e.getMessage());
            e.printStackTrace();
        }
        finally {
            if(driver != null){
                driver.quit();
            }
        }
    }
}
