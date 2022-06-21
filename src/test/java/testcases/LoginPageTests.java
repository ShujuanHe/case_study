package testcases;


import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CustomerLoggedInPage;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTests{
    CustomerLoggedInPage customerLoggedInPage;
    LoginPage loginPageActions;

    @Test(priority = 1)
    public void testSuccessfulLogin() throws Exception {

        loginPageActions = homePage.clickAccountBtn();
        test.log(Status.INFO, "Login Page is opened!");
        loginPageActions.setEmailField("shujuanhe1@gmail.com");
        loginPageActions.setPasswordField("691122");
        test.log(Status.INFO, "Email and password is entered!");
        CustomerLoggedInPage customerLoggedInPage = loginPageActions.clickLoginButton();
        Thread.sleep(4000);


        customerLoggedInPage.clickCheckBox();

    }
    @Test(priority = 2)
    public void testFailedLogin() throws IOException, InterruptedException {
        //test = extent.createTest("login_succeed_test", "Test Passed");
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.setEmailField("shujuanhe123@gmail.com");
        loginPage.setPasswordField("691122");
        test.log(Status.INFO, "Entered above info!");
        customerLoggedInPage = loginPage.clickLoginButton();
        test.log(Status.INFO, "Clicked on the login button");
        Thread.sleep(20000);

        assertTrue(loginPage.getEmailErrorMessage()
                        .contains("Sorry! Please try that again."),
                "Alert text is incorrect");

    }
}