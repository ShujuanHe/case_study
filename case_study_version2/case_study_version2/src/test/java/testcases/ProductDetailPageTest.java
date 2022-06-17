package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerLoggedInPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ProductDetailPageTest extends BaseTests{
    HomePage homePage;
    ProductDetailPage productDetailPage;

    @Test(priority = 1)
    public void testProductDetails() throws IOException {
        //test = extent.createTest("login_succeed_test", "Test Passed");
        homePage = new HomePage(driver);
        productDetailPage = homePage.clickAnyProduct();

        String expectedText = "$99.95 USD";
        String actualText = productDetailPage.checkProductPrice();
        Assert.assertEquals(actualText,expectedText);



       // assertTrue(customerLoggedInPage.getAlertText().contains("Welcome, Shujuan"), "Alert text is incorrect");
       /* File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screenshots/loginPage.png"));
        test.addScreenCaptureFromPath("loginPage.png");*/
    }

    @Test(priority = 2)
    public void testAddToCart() throws IOException {
        //test = extent.createTest("login_succeed_test", "Test Passed");
        homePage = new HomePage(driver);
        productDetailPage = homePage.clickAnyProduct();

        //ProductDetailPage actions
        productDetailPage.setProductSize();
        productDetailPage.setProductColor();
        productDetailPage.setProductQty("2");

        String expectedURL = "https://www.alexandnova.com/cart";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

    }

}
