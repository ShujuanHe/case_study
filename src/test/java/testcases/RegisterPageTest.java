package testcases;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.File;
import java.io.IOException;

public class RegisterPageTest extends BaseTests {

    LoginPage loginPageActions;
    RegisterPage registerPageActions;

    /**
     * TC - 0001 New User Registration page
     * Expected Result: Navigate to the below Registration Form
     * https://www.alexandnova.com/account/register
     * <p>
     * Status: Passed
     */
    @Test(priority = 1)
    public void testNavigateToRegister() {

        //LoginPage actions
        loginPageActions = homePage.clickAccountBtn();
        test.log(Status.INFO, "Clicked on 'Account' button");
        loginPageActions.moveToRegisterBtn();
        loginPageActions.clickRegisterBtn();
        test.log(Status.INFO, "Clicked on 'REGISTER' button");

        String expectedURL = "https://www.alexandnova.com/account/register";
        String actualURL = driver.getCurrentUrl();
        test.log(Status.INFO, "Navigate to the Registration Form: https://www.alexandnova.com/account/register");

        Assert.assertEquals(actualURL, expectedURL);

    }

    /**
     * TC - 0002 Verify Register New User --positive testing.
     * Test data --valid: First name: fink, Last name: john, Email: testAtgmail.com and Password: P@ssword
     * Expected Result:
     * -Navigate to the Welcome page
     * -Verify that a Welcome message is displayed to the user.
     * <p>
     * Test status: Passed
     * <p>
     * Can be improved: Need to make sure data like password safe
     */
    @Test(priority = 2)
    public void testSuccessfulRegister() throws Exception {

        //LoginPage actions
        loginPageActions = homePage.clickAccountBtn();
        loginPageActions.moveToRegisterBtn();

        //RegisterPage actions

        registerPageActions = loginPageActions.clickRegisterBtn();
        registerPageActions.setFirstNameField("fink");
        registerPageActions.setLastNameField("john");
        registerPageActions.setEmailField("testAt@gmail14.com");
        registerPageActions.setPasswordField("P@ssword4");
        test.log(Status.INFO, "Entered: First name, Last name, Email and Password!");
        registerPageActions.clickRegister();
        test.log(Status.INFO, "Register button clicked, Navigate to the Logged in page");
        Thread.sleep(30000);

        /** Below can handle capture separately
         * if(driver.getCurrentUrl() == "https://www.alexandnova.com/challenge"){
         Thread.sleep(30000);
         registerPageActions.handleCaptcha();
         }**/

        /**
         * Below method is for Page factory
         // RegisterPage registerPage2 = new RegisterPage(driver);
         */

        Assert.assertTrue(registerPageActions.myAccountLinkIsDisplayed());

    }


    /**
     * TC - 0003 Check the Email text field that has an Email address without @ symbol.
     * Test data: estAtgmail.com
     * Expected result: "Sorry! Please try that again."
     * <p>
     * Test status: Passed
     *
     * @throws IOException
     */
    @Test(priority = 3)
    public void testEmailValidation() throws Exception {

        //LoginPage actions
        loginPageActions = homePage.clickAccountBtn();
        loginPageActions.moveToRegisterBtn();

        //RegisterPage actions
        registerPageActions = loginPageActions.clickRegisterBtn();

        registerPageActions.setFirstNameField("john");
        registerPageActions.setLastNameField("fink");
        registerPageActions.setEmailField("testAtgmail.com");
        registerPageActions.setPasswordField("P@ssword");
        test.log(Status.INFO, "Entered: Valid- First name, Last name,and Password. Invalid- Email:testAtgmail.com   ");
        registerPageActions.clickRegister();
        test.log(Status.INFO, "Clicked 'REGISTER' button");
        Thread.sleep(30000);

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPageActions.getEmailErrorMessage(); //Because the error message shows in Login in page
        test.log(Status.INFO, "Navigate back to Login page and got error message: 'Sorry! Please try that again.'");

        Assert.assertEquals(expectedMessage, actualMessage);


    }

    /**
     * TC - 0004 Negative testing for Mandatory fields
     * Test data: Leave these fields blank: First name, Last name, Email and Password
     * Expected result: "Sorry! Please try that again."
     * <p>
     * Test status: Passed
     *
     * @throws IOException
     */
    @Test(priority = 4)
    public void testEmailMandatory() throws Exception {

        //LoginPage actions
        loginPageActions = homePage.clickAccountBtn();
        loginPageActions.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPageActions.clickRegisterBtn();

        registerPage.setFirstNameField("");
        registerPage.setLastNameField("");
        registerPage.setEmailField("");
        registerPage.setPasswordField("");
        test.log(Status.INFO, "Leave these fields blank: First name, Last name, Email and Password");
        registerPage.clickRegister();
        test.log(Status.INFO, "Clicked 'REGISTER' button");
        Thread.sleep(30000);

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPageActions.getEmailErrorMessage(); //Because the error message shows in Login in page
        test.log(Status.INFO, "Navigate back to Login page and got error message: 'Sorry! Please try that again.'");

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    /**
     * TC - 0005 Negative testing for password
     * Test data: Password: passwd
     * Expected result: passwd is invalid.
     * <p>
     * Test status: Failed
     * <p>
     * Failed reason: Expected result should show: "passwd is invalid.", but show:"Sorry! Please try that again."
     * <p>
     * Need to be reviewed
     *
     * @throws IOException
     */
    @Test(priority = 5)
    public void testPassRules() throws Exception {

        //LoginPage actions
        loginPageActions = homePage.clickAccountBtn();
        loginPageActions.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPageActions.clickRegisterBtn();

        registerPage.setFirstNameField("john");
        registerPage.setLastNameField("fink");
        registerPage.setEmailField("testAtgmail9.com");
        registerPage.setPasswordField("passwd");
        registerPage.clickRegister();
        test.log(Status.INFO, "Entered valid First name, Last name, Email and Invalid Password!");
        Thread.sleep(30000);

        String expectedMessage = "passwd is invalid.";
        String actualMessage = loginPageActions.getEmailErrorMessage(); //Because the error message shows in Login in page
        test.log(Status.INFO, "Navigate back to Login page and got error message: 'Sorry! Please try that again.'");

        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
