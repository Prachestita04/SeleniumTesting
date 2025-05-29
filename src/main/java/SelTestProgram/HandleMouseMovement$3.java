package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleMouseMovement$3 {
    private static final String driverType = "webdriver.edge.driver";
    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://www.flipkart.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(driverType, driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement firstHoverElement = driver.findElement(By.xpath("(//div[@class = 'YBLJE4'])[4]"));
//        firstHoverElement.click();
        Actions action = new Actions(driver);
        action.moveToElement(firstHoverElement).build().perform();
        Thread.sleep(5000);
        WebElement secondHoverElement = driver.findElement(By.xpath("(//a[@class = '_1BJVlg'])[4]"));
        action.moveToElement(secondHoverElement).build().perform();
        WebElement chosenElement = driver.findElement(By.xpath("(//a[@class='_3490ry'])[3]"));
        chosenElement.click();
        Thread.sleep(3000);
        System.out.println("Successfully hovered and clicked the selected element..");
        driver.quit();
    }
}
