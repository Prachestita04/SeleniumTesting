package FailedScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class $2BaseClass {
    static WebDriver driver;

    public static void initialization(){
        driver = new EdgeDriver();
        driver.get("https://www.google.com/");
    }

    public static void failed() throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\user\\Pictures\\Screenshots\\fail1.png"));
    }

    public static void closure(){
        driver.quit();
    }
}
