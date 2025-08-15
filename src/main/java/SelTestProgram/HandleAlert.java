package SelTestProgram;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class HandleAlert {
//    private static final String driverType = "webdriver.edge.driver";
//    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://mail.rediff.com/cgi-bin/login.cgi";

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty(driverType, driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement loginClick = driver.findElement(By.name("proceed"));
        loginClick.click();
        Thread.sleep(10000);
        Alert loginAlert = driver.switchTo().alert();
        System.out.println(loginAlert.getText());
        String msg = loginAlert.getText();
        if (msg.equals("Please enter a valid user name")) {
            System.out.println("Correct alert message...");
        } else {
            System.out.println("Incorrect text message....");
        }

        loginAlert.accept();
//        loginAlert.dismiss();
//        Thread.sleep(10000);

        driver.quit();
    }
}
