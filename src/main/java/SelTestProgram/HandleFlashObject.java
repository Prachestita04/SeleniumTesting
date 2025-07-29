package SelTestProgram;

import com.tigervnc.rfb.Screen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.Pattern;

import java.time.Duration;

public class HandleFlashObject {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.youtube.com/watch?v=fAfljp9dovE&list=RDfAfljp9dovE&start_radio=1");

        Screen s = new Screen();
        Pattern pauseImg = new Pattern("YT_pausebtn.jpg");
        s.wait(2000);


//        driver.quit();
    }
}
