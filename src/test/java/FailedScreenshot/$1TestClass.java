package FailedScreenshot;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static FailedScreenshot.$2BaseClass.closure;
import static FailedScreenshot.$2BaseClass.initialization;

@Listeners(_3CustomListener.class)
public class $1TestClass {
    @BeforeTest
    public void setup(){
        initialization();
    }

    @Test
    public static void titleTest(){
        System.out.println("Title Verification");
        int i=0;
        System.out.println(9/i);
    }

    @Test
    public static void logoTest(){
        System.out.println("Logo Verification");
    }

    @Test
    public static void someElementTest(){
        System.out.println("Some Element Verification");
    }

    @AfterTest
    public void tearDown(){
        closure();
    }
}
