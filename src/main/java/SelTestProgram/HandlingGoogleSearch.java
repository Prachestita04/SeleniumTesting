package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.python.antlr.ast.Str;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class HandlingGoogleSearch {
    static WebDriver driver;
    static final String filePath = "C:\\Users\\user\\IdeaProjects\\SeleniumTesting\\src\\main\\java\\SelTestProgram\\myFile.properties";
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
        if (!getPropertyValue("browser").equalsIgnoreCase("edge")) {
            System.err.println("Unsupported browser or Browser property is not defined properly");
            return;
        }
        driver = new EdgeDriver();
        try {
            driver.get(getPropertyValue("googleUrl"));
            basicBrowserFunctions(driver, 40, 30);
            WebElement searchBar = driver.findElement(By.xpath(getPropertyValue("searchBox")));
            searchBar.sendKeys("testing");
            searchBar.click();
            List<WebElement> searchResults = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]/li//span/b"));
            for (WebElement eachResult:searchResults){
                if(eachResult.getText().equalsIgnoreCase("techniques")){
                    eachResult.click();
                    break;
                }
            }
            Thread.sleep(3000);
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
            throw new IllegalArgumentException("Missing Properties" + key);
        }
        return value.trim();
    }

    private static void basicBrowserFunctions(WebDriver driver, int pageTimeOut, int implicitTimeOut) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeOut));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));
    }
}
