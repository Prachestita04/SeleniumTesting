import org.testng.annotations.Test;

/* use dependsOnGroups parameter */

public class TestNgBasics11 {
    @Test(groups = "registration",dependsOnGroups = "login")
    public void showTest() {
        System.out.println("@showTest -  check showTitle functionality");
    }

    @Test(groups = "login")
    public void searchTest() {
        System.out.println("@searchTest - search functionality test");
    }

    @Test(priority = 1, groups = "login")
    public void titleTest() {
        System.out.println("@titleTest0 -  check title of your app");
    }

}
