package SelTestProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
    public static void main(String[] args) {
        System.getProperty("webdriver.edge.driver","C:\\Users\\user\\Downloads\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }
}
