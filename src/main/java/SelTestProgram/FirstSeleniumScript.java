package SelTestProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class FirstSeleniumScript {
    private static final String driverType = "webdriver.edge.driver";
    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "http://www.google.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(driverType,driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        Thread.sleep(10000);

        driver.quit();
    }
}
