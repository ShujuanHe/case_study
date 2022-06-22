package testcases;


import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CustomerLoggedInPage;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;
public class LoginPageTests extends BaseTests{
    CustomerLoggedInPage customerLoggedInPage;
    LoginPage loginPageActions;

    /** TC - 0007 Verify when passing incorrect Email and correct password to Login page
     * Test data-
     * Email: wrongemail@gmail.com
     * Password: wrongpass
     * Expected result: "Sorry! Please try that again."
     *
     * Test status: passed
     * @throws Exception
     */
    @Test(priority = 1)
    public void testFailedLogin() throws Exception {

        loginPageActions = homePage.clickAccountBtn();
        loginPageActions.setEmailField("wrongemail@gmail.com");
        loginPageActions.setPasswordField("wrongpass");
        test.log(Status.INFO, "Entered Invalid email and password");
        customerLoggedInPage = loginPageActions.clickLoginButton();
        test.log(Status.INFO, "Clicked on the login button");
        Thread.sleep(30000);

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPageActions.getEmailErrorMessage(); //Because the error message shows in Login in page
        test.log(Status.INFO, "Navigate back to Login page and got error message: 'Sorry! Please try that again.'");

        Assert.assertEquals(expectedMessage, actualMessage);

        /*assertTrue(loginPage.getEmailErrorMessage()
                        .contains("Sorry! Please try that again."),
                "Alert text is incorrect");*/

    }

    /** TC - 0006 Positive testing for login
     * Test data-
     * Email: shujuanhe1@gmail.com
     * Password: 691122
     * Expected result: User should login and User Dashboard Page is displayed
     *
     * Test status: passed
     *
     * @throws Exception
     */
    @Test(priority = 2)
    public void testSuccessfulLogin() throws Exception {

        /**
         * Credential information could be handled better
         *
         */
        loginPageActions = homePage.clickAccountBtn();
        test.log(Status.INFO, "Login Page is opened!");
        loginPageActions.setEmailField("shujuanhe1@gmail.com");
        loginPageActions.setPasswordField("691122");
        test.log(Status.INFO, "Email and password is entered!");
        customerLoggedInPage = loginPageActions.clickLoginButton();
        Thread.sleep(5000);

        String expectedWelcomeMess = "Welcome, Shujuan";
        String actualWelcomeMess = customerLoggedInPage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMess,expectedWelcomeMess);




    }
}
