package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

public class DifferentTypesOfWait {
    static WebDriver driver;
    static final String filePath = "C:\\Users\\user\\IdeaProjects\\SeleniumTesting\\src\\main\\java\\SelTestProgram\\myFile1.properties";
    static Properties properties = new Properties();

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find file properties at specified location" + filePath);
            return;
        } catch (IOException e) {
            System.err.println("Error occurred while reading file properties" + e.getMessage());
            return;
        }
        if(!getPropertyValue("browser").equalsIgnoreCase("edge")){
            System.err.println("Unsupported browser or Browser property is not defined properly");
            return;
        }
        driver = new EdgeDriver();
        try{
            driver.get(getPropertyValue("baseurl"));
            basicBrowserFunction(driver,40,30);
            WebElement userName = driver.findElement(By.name("email"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement login = driver.findElement(By.xpath("//div[text()='Login']"));
            userName.sendKeys("mahapatrap040@gmail.com");
            password.sendKeys("Prachi@123");
            login.click();

            WebElement calender = driver.findElement(By.xpath("//span[text()='Calendar']//parent::a"));

            //First Types of Wait - static wait - never recommended
            Thread.sleep(10000);

            /*
            Dynamic Wait
            1. Implicit wait - is applicable at each element level
            2. Explicit wait - is applicable at single element level
            3. Fluent wait - is applicable at single element level
            Other types of wait
            pageLoadTimeOut - is applicable at page level
             */

            //explicit wait
            waitForElement(calender,40);

            //fluent wait
            waitForElementFluently(40);


        } catch (Exception e) {
            System.err.println("Error occurred while running selenium automation" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (driver!=null){
                driver.quit();
            }
        }
    }
    private static String getPropertyValue(String key){
        String value = properties.getProperty(key);
        if(value==null || value.trim().isEmpty()){
            throw new IllegalArgumentException("Missing properties"+key);
        }
        return value.trim();
    }

    private static void basicBrowserFunction(WebDriver driver, int pageTimeOut, int implicitTimeOut){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeOut));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));

    }

    private static void waitForElement(WebElement element,int waitTimeOut){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTimeOut));
        //wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private static void waitForElementFluently(int waitTimeOut){
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class);

        /*
        WebElement element = wait1.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("element-id"));
            }
        });
         */

    }
}
