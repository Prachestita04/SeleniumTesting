package Verbose;

import org.testng.annotations.Test;

public class FBTest1 {

    @Test
    public static void titleTest(){
        System.out.println("Title Verification");
    }

    @Test
    public static void logoTest(){
        System.out.println("Logo Verification");
    }

    @Test
    public static void someElementTest(){
        System.out.println("Some Element Verification");
    }
}
