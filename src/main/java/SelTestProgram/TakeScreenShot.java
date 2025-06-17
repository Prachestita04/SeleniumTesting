package SelTestProgram;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenShot {
    static String baseurl = "https://www.google.com/";

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

//        Thread.sleep(5000);
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("C:\\Users\\user\\Pictures\\Screenshots\\seleniumtestss.png"));
        driver.quit();
    }
}
