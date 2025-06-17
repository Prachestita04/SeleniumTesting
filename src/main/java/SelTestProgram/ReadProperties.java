package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ReadProperties {
    static WebDriver driver;
    static String fileLocation = "C:\\Users\\user\\IdeaProjects\\SeleniumTesting\\src\\main\\java\\SelTestProgram\\myFile.properties";
    static Properties properties = new Properties();

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileLocation);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.err.println("File not found at the location" + fileLocation);
            return;
        } catch (IOException e) {
            System.err.println("Error in reading file" + e.getMessage());
            return;
        }
        if (!getPropertyValue("browser").equalsIgnoreCase("edge")) {
            System.err.println("Unsupported browser or browser is not properly defined.");
            return;
        }
        driver = new EdgeDriver();
        try {
            driver.get(getPropertyValue("baseurl"));
            basicDriverFunction(driver, 40, 30);

            WebElement emailTxtBox;
            WebElement passTxtBox ;
            emailTxtBox = findElementByLocator(By.id(getPropertyValue("emailBar")));
            passTxtBox = findElementByLocator(By.id(getPropertyValue("passBar")));
            fillDetails(emailTxtBox, passTxtBox);
        } catch (Exception e) {
            System.err.println("Exception occurred while running selenium automation" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

    }

    private static String getPropertyValue(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing property: " + key);
        }
        return value.trim();
    }

    private static void basicDriverFunction(WebDriver driver, int pageTimeOut, int impliTimeOut) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeOut));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impliTimeOut));
    }

    private static void pauseTheScript(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {

        }
    }

    private static void fillDetails(WebElement email, WebElement pass) {
        for (int i = 0; i < 5; i++) {
            email.sendKeys("email" + i);
            pass.sendKeys("pass" + i);
            pauseTheScript(5000);
            email.clear();
            pass.clear();
        }
    }
    private static WebElement findElementByLocator(By by){
        try{
            WebElement ele = driver.findElement(by);
            return ele;
        }
        catch (RuntimeException e){
             throw new RuntimeException("Unable to find element or element property is incorrect"+by.toString());
        }
    }
}
