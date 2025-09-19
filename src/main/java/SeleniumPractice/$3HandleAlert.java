package SeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class $3HandleAlert {
    static String baseurl = "https://mail.rediff.com/cgi-bin/login.cgi";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

        WebElement loginClick = driver.findElement(By.name("proceed"));
        loginClick.click();
//        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String alertMsg = alert.getText();
        if (alertMsg.equals("Please enter a valid user name")){
            System.out.println("Correct alert msg");
        }
        else {
            System.out.println("Incorrect alert msg");
        }

//        alert.accept();
        alert.dismiss();
        Thread.sleep(3000);

        driver.quit();
    }
}
