package SelTestProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;

public class NavigateBackForward {
    static String baseurl1 = "https://www.google.com/";
    static String baseurl2 = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl1);

        driver.navigate().to(baseurl2);
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);

        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.quit();
    }
}
