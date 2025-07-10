package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DiffBtnSomeFunctions {
    static String baseurl = "https://www.facebook.com/r.php?entry_point=login";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);
//        Thread.sleep(2000);
//        WebElement dataSelect = driver.findElement(By.id("day"));
//        Select select = new Select(dataSelect);
//        System.out.println(dataSelect.isDisplayed());
//        System.out.println(dataSelect.isEnabled());
//        if(!dataSelect.isSelected()){
//            select.selectByValue("10");
//            System.out.println(dataSelect.isSelected());
//        }

        WebElement femaleBtn = driver.findElement(By.id("sex"));
        femaleBtn.click();
        System.out.println(femaleBtn.isDisplayed());
        System.out.println(femaleBtn.isEnabled());
        System.out.println(femaleBtn.isSelected());
        driver.quit();
    }
}
