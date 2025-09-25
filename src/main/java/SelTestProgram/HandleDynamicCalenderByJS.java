package SelTestProgram;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleDynamicCalenderByJS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.spicejet.com/");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement departureDate = driver.findElement(By.xpath("//div[contains(@data-testid,'departure-date-dropdown-label-test-id')]//div[contains(text(),'Thu, 2 Oct 2025')]"));
        System.out.println("Before wait");
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(departureDate));
        System.out.println("After wait");
        String requiredDate = "Tue, 31 Sep 2025";
//        departureDate.sendKeys(requiredDate);
        inputDataBJS(driver,departureDate,requiredDate);
        Thread.sleep(5000);

        driver.quit();
    }
    private static void inputDataBJS(WebDriver driver,WebElement element,String string){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText='"+string+"';",element); //(arguments[0].innerText='webelementvalue';element)
    }

    //don't use below
//    private static void inputDataBJS(WebDriver driver,WebElement element,String string){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('value','" + string + "');",element); //(arguments[0].setAttribute('value','webelementvalue');
//    }

}
