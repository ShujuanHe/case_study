package testcases;


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



    @Test(priority = 1)
    public void testSuccessfulLogin() throws IOException {
        //test = extent.createTest("login_succeed_test", "Test Passed");
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.setEmailField("shujuanhe1@gmail.com");
        loginPage.setPasswordField("691122");
        CustomerLoggedInPage customerLoggedInPage = loginPage.clickLoginButton();

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span")));*/
        customerLoggedInPage.clickCheckBox();


        assertTrue(customerLoggedInPage.getAlertText().contains("Welcome, Shujuan"), "Alert text is incorrect");
       /* File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/loginPage.png"));
        test.addScreenCaptureFromPath("loginPage.png");*/
    }
    @Test(priority = 2)
    public void testFailedLogin() throws IOException {
        //test = extent.createTest("login_succeed_test", "Test Passed");
        LoginPage loginPage = homePage.clickAccountBtn();
        loginPage.setEmailField("shujuanhe123@gmail.com");
        loginPage.setPasswordField("691122");
        customerLoggedInPage = loginPage.clickLoginButton();

       /* String expectedMess = "Sorry! Please try that again.";
        String actural = customerLoggedInPage.getErrorMessage();*/


        assertTrue(customerLoggedInPage.getErrorMessage()
                        .contains("Sorry! Please try that again."),
                "Alert text is incorrect");
        /*File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/loginPage.png"));
        test.addScreenCaptureFromPath("loginPage.png");*/
    }
}
