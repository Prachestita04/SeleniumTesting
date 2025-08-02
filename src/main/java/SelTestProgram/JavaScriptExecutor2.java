package SelTestProgram;

import org.openqa.selenium.*;
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

            String alertMessage = "Hey! Welcome to Facebook";
            generateAlert(driver,alertMessage);
            driver.switchTo().alert().accept();

            refreshBrowser(driver);

            String findTitleUsingSelenium = driver.getTitle();
            String findCurrentUrlUsingSelenium = driver.getCurrentUrl();

            System.out.println("Title using Selenium method: "+findTitleUsingSelenium);
            System.out.println("Current Url using Selenium method: "+findCurrentUrlUsingSelenium);

            System.out.println("Title using JSE method: "+getTitleUsingJSE(driver));

            System.out.println("Inner text of the whole page is: "+getInnerText(driver));

            clickElementByJSE(driver,loginBtn);
            driver.navigate().to(getPropertyValue("wikipediaPage"));
//            scrollEndOfThePage(driver);
            WebElement starLinkElement = driver.findElement(By.id(getPropertyValue("starLinkTxt")));
            scrollToaParticularPoint(driver,starLinkElement);


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

    private static void generateAlert(WebDriver driver,String msg) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + msg + "')");
        Thread.sleep(5000);
    }

    private static void refreshBrowser(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0);");
        Thread.sleep(5000);
    }

    private static String getTitleUsingJSE(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object title = js.executeScript("return document.title;");
        assert title != null;
        return title.toString();
    }

    private static String getInnerText(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        return innerText;
    }

    private static void clickElementByJSE(WebDriver driver,WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].click();", element);
        }
        catch (StaleElementReferenceException e){
            WebElement loginBtn = driver.findElement(By.name(getPropertyValue("loginBtn")));
            js.executeScript("arguments[0].click();",loginBtn);
        }
        Thread.sleep(5000);
    }
    private static void scrollEndOfThePage(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(5000);
    }

    private static void scrollToaParticularPoint(WebDriver driver,WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(5000);
    }
}
