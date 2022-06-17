package testcases;

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


      /*  File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("test-output/xml/RegisterPage.png"));*/


    }
    @Test(priority = 2)
    public void testSuccessfulRegister(){
        //test = extent.createTest("Register_succeed_test", "Test Passed");
        //LoginPage actions
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.moveToRegisterBtn();

        //RegisterPage actions
        RegisterPage registerPage = loginPage.clickRegisterBtn();
        registerPage.setFirstNameField("Silly");
        registerPage.setLastNameField("pig");
        registerPage.setEmailField("heshujuan9988@gmail.com");
        registerPage.setPasswordField("12345");
        registerPage.clickRegister();

        String expectedURL = "https://www.alexandnova.com/account/register";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

       /* File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/RegisterLoggedPage.png"));*/
       // test.addScreenCaptureFromPath("RegisterLoggedPage.png");




    }


    @Test(priority = 3)
    public void testEmailValidation() throws IOException {
        //test = extent.createTest("Register_succeed_test", "Test Passed");
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

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPage.getEmailErrorMessage(); //Because the error message shows in Login in page

        Assert.assertEquals(expectedMessage,actualMessage);

       /* File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/EmailValidation.png"));*/
      //  test.addScreenCaptureFromPath("RegisterLoggedPage.png");

    }

    @Test(priority = 4)
    public void testEmailMandatory() throws IOException {
        //test = extent.createTest("Register_succeed_test", "Test Passed");
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

       /* File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/EmailValidation.png"));*/
       // test.addScreenCaptureFromPath("RegisterLoggedPage.png");

    }

    @Test(priority = 5)
    public void testPassRules() throws IOException {
        //test = extent.createTest("Register_succeed_test", "Test Passed");
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

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = loginPage.getEmailErrorMessage(); //Because the error message shows in Login in page

        Assert.assertEquals(expectedMessage,actualMessage);

       /* File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/EmailValidation.png"));*/
        //test.addScreenCaptureFromPath("RegisterLoggedPage.png");

    }
}
