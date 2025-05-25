package SelTestProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HandleWindows {
    private static final String driverType = "webdriver.edge.driver";
    private static final String driverLocation = "C:\\Users\\user\\Downloads\\msedgedriver.exe";
    static String baseurl = "https://www.amazon.in/s?rh=n%3A1389401031%2Cp_123%3A110955&dc&qid=1747970257&rnid=91049095031&ref=sr_nr_p_123_1";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(driverType,driverLocation);
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(baseurl);

//        WebElement product = driver.findElement(By.xpath("(//a[@class='a-link-normal s-line-clamp-4 s-link-style a-text-normal'])[2]"));
//        product.click();

        List<WebElement> products = driver.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-4 s-link-style a-text-normal']"));
        int count = 0;
        for (WebElement eachProduct: products){
            if(count<3){
                eachProduct.click();
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
                driver.close();
            }
        }

        driver.switchTo().window(parentWindowId);
        driver.quit();
    }
}
