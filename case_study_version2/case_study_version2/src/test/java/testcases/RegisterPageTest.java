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

public class RegisterPageTest extends BaseTests{

    @Test(priority = 1)
    public void testNavigateToRegister() {

        //LoginPage actions
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.moveToRegisterBtn();
        loginPage.clickRegisterBtn();

        String expectedURL = "https://www.alexandnova.com/account/register";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

    }
    @Test(priority = 2)
    public void testSuccessfulRegister(){

        //LoginPage actions
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPage.clickRegisterBtn();
        registerPage.setFirstNameField("Silly");
        registerPage.setLastNameField("pig");
        registerPage.setEmailField("heshujuan9988@gmail.com");
        registerPage.setPasswordField("12345");
        test.log(Status.INFO, "Entered above info!");
        registerPage.clickRegister();

        String expectedURL = "https://www.alexandnova.com/account/register";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

    }


    @Test(priority = 3)
    public void testEmailValidation() throws IOException {

        //LoginPage actions
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPage.clickRegisterBtn();

        registerPage.setFirstNameField("Silly");
        registerPage.setLastNameField("pig");
        registerPage.setEmailField("heshujuan9988gmail.com");
        registerPage.setPasswordField("12345");
        registerPage.clickRegister();
        test.log(Status.INFO, "Entered above info!");

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPage.getEmailErrorMessage(); //Because the error message shows in Login in page

        Assert.assertEquals(expectedMessage,actualMessage);


    }

    @Test(priority = 4)
    public void testEmailMandatory() throws IOException {

        //LoginPage actions
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPage.clickRegisterBtn();

        registerPage.setFirstNameField(" ");
        registerPage.setLastNameField("pig");
        registerPage.setEmailField("heshujuan9988gmail.com");
        registerPage.setPasswordField("12345");
        registerPage.clickRegister();

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPage.getEmailErrorMessage(); //Because the error message shows in Login in page

        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test(priority = 5)
    public void testPassRules() throws IOException {

        //LoginPage actions
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPage.clickRegisterBtn();

        registerPage.setFirstNameField("Shujuan");
        registerPage.setLastNameField("He");
        registerPage.setEmailField("heshujuan9988gmail.com");
        registerPage.setPasswordField("12");
        registerPage.clickRegister();
        test.log(Status.INFO, "Entered above info!");

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPage.getEmailErrorMessage(); //Because the error message shows in Login in page

        Assert.assertEquals(expectedMessage,actualMessage);

    }
}
