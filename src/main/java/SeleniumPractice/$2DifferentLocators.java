package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class $2DifferentLocators {
    static final String baseUrl = "https://demowebshop.tricentis.com/login";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseUrl);

        //id locator
//        WebElement searchName = driver.findElement(By.id("small-searchterms"));
//        searchName.sendKeys("name");


        //xpath locator
//        WebElement searchName = driver.findElement(By.xpath("//input[@id = 'small-searchterms']"));
//        searchName.sendKeys("name");

        //cssselector locator
//        WebElement searchName = driver.findElement(By.cssSelector("#small-searchterms"));
//        searchName.sendKeys("name");

        //name locator
//        WebElement searchName = driver.findElement(By.name("q"));
//        searchName.sendKeys("name");

        //classname locator
//        WebElement registerOption = driver.findElement(By.className("ico-register"));
//        registerOption.click();


        //tagname locator
//        WebElement searchName = driver.findElement(By.tagName("input"));
//        searchName.sendKeys("name");

        //linkText Locator
//        WebElement registerLink = driver.findElement(By.linkText("Register"));
//        registerLink.click();

        //partiallinktext locator
//        WebElement registerLink = driver.findElement(By.partialLinkText("ster"));
//        registerLink.click();


        Thread.sleep(3000);
        driver.quit();
    }
}
