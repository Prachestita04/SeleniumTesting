package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class HandleDynamicWebTable {
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
            WebElement contact = driver.findElement(By.xpath(getPropertyValue("contact")));
            contact.click();
            Actions actions = new Actions(driver);
//            WebElement freeAccount = driver.findElement(By.linkText("Free account"));
//            actions.moveToElement(freeAccount).perform();
            Thread.sleep(5000);

            List<WebElement> nameList = driver.findElements(By.xpath("//table[contains(@class,'celled')]//tr/td[2]/a"));
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/contacts/2856be17-a7ab-4d35-b8f9-d4ff89965c03']")));
//            element.click();
            for (WebElement name:nameList){
                if (name.getText().equalsIgnoreCase("free lancer")){
                    name.click();
                    Thread.sleep(10000);
                    System.out.println("Done");
                }
                System.out.println("Out of if");
            }
            System.out.println("Out of for");
            Thread.sleep(5000);
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

    private static void basicBrowserFunction(WebDriver driver,int pageTimeOut, int implicitTimeOut){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeOut));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));

    }
}
