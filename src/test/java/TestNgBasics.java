import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgBasics {
    @BeforeSuite
    public void setup(){
        System.out.println("Setup");
    }
    @Test
    public void login(){
        System.out.println("Login");
    }
    @AfterSuite
    public void logout(){
        System.out.println("Logout");
    }
}

/*
1. High Priority testcases: -
* verify user is able to login with valid credentials
* verify successful transaction with valid credit card details
2. Low priority testcases: -
* verify alignment of the login button on the login page
* verify the dark mode colour theme toggle in healthcare domain website
3. High Priority defects/bugs: -
* Login failure with valid credentials
* payment not processed/order not placed after successful transaction
4. Low Priority defects: -
* minor UI misalignment on settings page
* typo in tooltip text - small spelling mistake
5. High Priority and low severity defects: -
* company name misspelled in home page
*incorrect terms and conditions link, terms and conditions link opens the wrong document
6. Low Priority and High severity defects: -
* critical crash in a rarely used features
* system fails during midnight batch job
7.Facebook page grouping example: -
* Facebook registration page: -
     - functional-verify successful registration with valid inputs
     - negative - verify error when mandatory fields are left blank
     - validation testcases - verify email format validation
     - verify alignment and visibility of input fields and buttons
     - browser compatibility - verify registration page works across multiple browsers, device compatibility(samsung,oneplus, realme)
* Friend Addition page: -
     - verify user can send a friend request to another valid user
     - negative - verify friend request can't be sent to a user who has blocked you
     - verify visibility and state change of the add friend button
     - validation testcases - verify duplicate friend addition is not allowed after cancelling and re - adding immediately
     - platform compatibility - verify friend request functionality in different platforms
     whatsapp(browser (laptop and mobile ) and desktop and mobile app,different - android, ios, windows
*Logout functionality: -
      -  Verify user is successfully logout when clicking
      - negative - verify that after logout accessing
      - verify session expiry after log out
      - cross browser compatibility test cases - verify logout works properly  or different browsers
      - verify visibility and accessibility of logout button on mobile and desktop.

 */
