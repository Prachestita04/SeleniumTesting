package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleMouseMovement$2 {
//    private static final String driverType = "webdriver.edge.driver";
//    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://jqueryui.com/droppable/";

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty(driverType, driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);

        WebElement draggedElement = driver.findElement(By.id("draggable"));
        WebElement droppedArea = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
//        action.dragAndDrop(draggedElement,droppedArea).build().perform();
        action.clickAndHold(draggedElement).moveToElement(droppedArea).release().build().perform();
        System.out.println("Successfully dragged and dropped...");
        Thread.sleep(5000);


        driver.quit();
    }
}
