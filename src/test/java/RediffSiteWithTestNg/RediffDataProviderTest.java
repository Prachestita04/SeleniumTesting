package RediffSiteWithTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class RediffDataProviderTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
    }

    @DataProvider
    public Iterator<Object[]> getDataFromExcel() {
        ArrayList<Object[]> testData = RediffTestUtil.getData();
        return testData.iterator();
    }

    @Test(dataProvider = "getDataFromExcel")
    public void inputData(String fullName, String email, String password,String rePass,String year,String gender,String country,String city) {
        WebElement fullNameTxtBox = driver.findElement(By.xpath("//input[@placeholder = 'Enter your full name']"));
        fullNameTxtBox.clear();
        fullNameTxtBox.sendKeys(fullName);

        WebElement emailTxtBox = driver.findElement(By.xpath("//input[@placeholder = 'Enter Rediffmail ID']"));
        emailTxtBox.clear();
        emailTxtBox.sendKeys(email);

        WebElement passwordTxtBox = driver.findElement(By.id("newpasswd"));
        passwordTxtBox.clear();
        passwordTxtBox.sendKeys(password);

        WebElement retypePasswordTxtBox = driver.findElement(By.id("newpasswd1"));
        retypePasswordTxtBox.clear();
        retypePasswordTxtBox.sendKeys(rePass);

        WebElement yearDropDown = driver.findElement(By.className("year"));
        Select selectYearDropDown = new Select(yearDropDown);
        selectYearDropDown.selectByVisibleText(year);

        WebElement genderRadioBtn = driver.findElement(By.className("gender"));
        Actions action = new Actions(driver);
        action.moveToElement(genderRadioBtn).build().perform();
        if(gender.equals("Male")){
            WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@type = 'radio' and @value = 'm' ]"));
            maleRadioBtn.click();
        }
        else {
            WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@type = 'radio' and @value = 'f' ]"));
            femaleRadioBtn.click();
        }

        WebElement countryDropDown = driver.findElement(By.id("country"));
        Select selectCountryDropDown = new Select(countryDropDown);
        selectCountryDropDown.selectByVisibleText(country);

        WebElement cityDropDown = driver.findElement(By.xpath("(//div[@class='form-group'])[8]//select"));
        Select selectCityDropDown = new Select(cityDropDown);
        selectCityDropDown.selectByVisibleText(city);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
