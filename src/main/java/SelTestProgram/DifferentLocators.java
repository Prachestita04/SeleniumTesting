package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DifferentLocators {
    private static final String driverType = "webdriver.edge.driver";
    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://demowebshop.tricentis.com/tricentis";

    public static void main(String[] args) throws InterruptedException {
        System.getProperty(driverType, driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        //locating by id
//        WebElement searchStoreById = driver.findElement(By.id("small-searchterms"));
//        searchStoreById.sendKeys("mamuni");
//        System.out.println("Successfully typed the text within search box");

        //locating by xpath
//        WebElement searchStoreByXpath = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
//        searchStoreByXpath.sendKeys("xpathtesting");
//        System.out.println("Successfully typed the text within search box");

        //locating by cssSelector
//        WebElement searchByCssSelector = driver.findElement(By.cssSelector("#small-searchterms"));
//        WebElement searchByCssSelector = driver.findElement(By.cssSelector(".search-box-text.ui-autocomplete-input"));
//        searchByCssSelector.sendKeys("Cssselector Testing");
//        System.out.println("Successfully typed the text within search box");

        //locating by name
//        WebElement searchByName = driver.findElement(By.name("q"));
//        searchByName.sendKeys("name testing");
//        System.out.println("Successfully typed the text within search box");

        //loacting by className
//        WebElement searchByClassName = driver.findElement(By.className("ico-register"));
//        searchByClassName.click();
//        System.out.println("Successfully clicked register option");

        //loacting by tagName
//        WebElement searchByTagName = driver.findElement(By.tagName("input"));
//        searchByTagName.sendKeys("Testing Tagname");
//        System.out.println("Successfully typed the text within search box");

        //locating by linkTest
//        WebElement searchByLinkTest = driver.findElement(By.linkText("Register"));
//        searchByLinkTest.click();
//        System.out.println("Successfully clicked register option");

        //locating by partiallinktest
        WebElement searchByPartialLinkTest = driver.findElement(By.partialLinkText("ister"));
        searchByPartialLinkTest.click();
        System.out.println("Successfully clicked register option");


        Thread.sleep(10000);
        driver.quit();
    }
}
