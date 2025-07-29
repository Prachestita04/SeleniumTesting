package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class JavaScriptExecutor2 {
    static WebDriver driver;
    static final String filePath = "C:\\Users\\user\\IdeaProjects\\SeleniumTesting\\src\\main\\java\\SelTestProgram\\myFile.properties";
    static Properties properties = new Properties();

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find properties file at specified location" + filePath);
            return;
        } catch (IOException e) {
            System.err.println("Error occurred while reading properties file" + e.getMessage());
            return;
        }

        if (!getPropertyValue("browser").equalsIgnoreCase("edge")) {
            System.err.println("Unsupported browser or browser property is not defined correctly");
            return;
        }
        driver = new EdgeDriver();

        try {
            driver.get(getPropertyValue("baseurl"));
            basicBrowserFunction(driver, 40, 30);
            WebElement loginBtn = driver.findElement(By.name(getPropertyValue("loginBtn")));
            drawBorder(driver, loginBtn);

        } catch (Exception e) {
            System.err.println("Error occurred while running selenium automation" + e.getMessage());
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
            throw new IllegalArgumentException("Missing properties" + key);
        }
        return value.trim();
    }

    private static void basicBrowserFunction(WebDriver driver, int pageTimeOut, int implicitTimeOut) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeOut));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));
    }

    private static void drawBorder(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid red'", element);
        Thread.sleep(3000);
    }
}
