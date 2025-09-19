package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandleDynamicCalender {
    static String baseUrl = "https://ui.cogmento.com/calendar";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new EdgeDriver();
        driver.get(baseUrl);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement userName = driver.findElement(By.name("email"));
        userName.sendKeys("mahapatrap040@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Prachi@123");

        WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Login']"));
        loginBtn.click();
        Thread.sleep(10000);

        //wait for the calender to be fully loaded
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'toolbar')]")));

        //Locate the left icon for month navigation
        WebElement leftIcon = driver.findElement(By.xpath("//i[@class='chevron left icon']//parent::button"));

        while (true){
            try {
                //Re-locate the monthYearLabel element before checking its text
                WebElement monthYearLabel = driver.findElement(By.xpath("//span[contains(@class,'toolbar')]"));

                //Check if the current month/year is September 2024
                if(monthYearLabel.getText().equalsIgnoreCase("september 2024")){
                    break;
                }

                //Click the leftIcon to go to the previous month
                leftIcon.click();

                //Wait for the DOM to be updated and monthYearLabel to become stale
                wait.until(ExpectedConditions.stalenessOf(monthYearLabel));

                //Re-locate the leftIcon to ensure it's fresh
                leftIcon = driver.findElement(By.xpath("//i[@class='chevron left icon']//parent::button"));

                //wait until the new monthYearLabel is visible and ready to interact with
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(@class,'toolbar')]")));
            } catch (StaleElementReferenceException e){
                //Handle stale element exception by re-locating the elements
                System.out.println("Caught StaleElementReferenceException. Re-locating the elements");
                leftIcon = driver.findElement(By.xpath("//i[@class='chevron left icon']//parent::button"));
            }
        }
        List<WebElement> listOfDates = driver.findElements(By.xpath("//button[@class='rbc-button-link']"));
        try {
            //wait until all elements are present
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='rbc-button-link']")));
            listOfDates = driver.findElements(By.xpath("//button[@class='rbc-button-link']"));

            for (WebElement element: listOfDates){
                System.out.println(element.getText());
            }
        } catch (StaleElementReferenceException e){
            System.out.println("Caught StaleElementReferenceException for button text. Re-locating the elements");

            //wait for staleness of the first element in the list(or any other element from the list)
            wait.until(ExpectedConditions.stalenessOf(listOfDates.get(0)));

            //Re-locate the elements after staleness
            listOfDates = driver.findElements(By.xpath("//button[@class='rbc-button-link']"));

            //Print the text  of the new list of the elements
            for (WebElement element: listOfDates){
                System.out.println(element.getText());
            }

        }

        driver.quit();
    }
}
