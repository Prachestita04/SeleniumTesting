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

public class JavaScriptExecutor1 {
    static WebDriver driver;
    static final String filePath = "C:\\Users\\user\\IdeaProjects\\SeleniumTesting\\src\\main\\java\\SelTestProgram\\myFile.properties";
    static Properties properties = new Properties();

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find properties file at the specified location" + filePath);
            return;
        } catch (IOException e) {
            System.err.println("Error occurred while reading properties file" + e.getMessage());
            return;
        }
        if (!getPropertyValue("browser").equalsIgnoreCase("edge")) {
            System.err.println("Unsupported browser or Browser property is not defined properly");
            return;
        }
        driver = new EdgeDriver();
        try {
            driver.get(getPropertyValue("baseurl"));
            basicBrowserFunctions(driver, 40, 30);
            WebElement loginBtn = driver.findElement(By.name(getPropertyValue("loginBtn")));
            String bgColor = "rgb(225,248,13)";
            flash(driver, loginBtn, bgColor);
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
            throw new IllegalArgumentException("Missing property" + key);
        }
        return value.trim();
    }

    private static void basicBrowserFunctions(WebDriver driver, int pageLoadTime, int implicitTime) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));
    }

    private static void changeColor(WebDriver driver, WebElement element, String bgColor) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background='" + bgColor + "'", element);
    }

    private static void flash(WebDriver driver, WebElement element, String newBackgroundColor) throws InterruptedException {
        String actualBackgroundColor = element.getCssValue("background-color");
        for (int i = 0; i < 5; i++) {
            changeColor(driver, element, newBackgroundColor);
            Thread.sleep(2000);
            changeColor(driver, element, actualBackgroundColor);
            Thread.sleep(2000);
        }
    }
}
