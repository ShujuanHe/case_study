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

    //TC - 0010
    @Test(priority = 1)
    public void testProductDetails() throws IOException {

        homePage = new HomePage(driver);
        productDetailPage = homePage.clickAnyProduct();

        String expectedText = "$99.95 USD";
        String actualText = productDetailPage.checkProductPrice();
        Assert.assertEquals(actualText,expectedText);

    }





}
