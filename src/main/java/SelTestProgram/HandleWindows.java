package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HandleWindows {
//    private static final String driverType = "webdriver.edge.driver";
//    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://www.amazon.in/s?k=mobile&crid=OL4N8DQZA3K6&sprefix=mobile%2Caps%2C341&ref=nb_sb_noss_2";

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty(driverType,driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

//        WebElement product = driver.findElement(By.xpath("(//a[@class='a-link-normal s-line-clamp-4 s-link-style a-text-normal'])[2]"));
//        product.click();
        List<WebElement> products = driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']//parent::a"));
        int count = 0;
        Actions actions = new Actions(driver);
        for (WebElement eachProduct: products){
            if(count<3){
                actions.contextClick(eachProduct).perform();
                actions.keyDown(Keys.CONTROL)   //press control key from keyboard
                        .click(eachProduct)   //click desired product
                        .keyUp(Keys.CONTROL)  //release control key and after that the product opens in a new tab
                        .build()
                        .perform();
//                Thread.sleep(5000);
            }
            count++;
        }
        Set<String> allWindows = driver.getWindowHandles();
        String parentWindowId = driver.getWindowHandle();
        System.out.println(parentWindowId);
//        String str = parentWindowId;
        Iterator<String> iterator = allWindows.iterator();

        while (iterator.hasNext()){
            String s1 = iterator.next();
            if(!(s1.equals(parentWindowId))){
                System.out.println(s1);
                driver.switchTo().window(s1);
                Thread.sleep(5000);
                driver.close();
            }
        }

        driver.switchTo().window(parentWindowId);
        driver.quit();
    }
}
