package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerLoggedInPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ProductDetailPageTest extends BaseTests {
    ProductDetailPage productDetailPage;

    /** TC - 0010 Verify the prices must show up for products on the product page
     * Expected result: the prices must show up for products on the product page
     *
     * Test status: Passed
     */
    @Test(priority = 1)
    public void testProductDetails(){

        productDetailPage = homePage.clickAnyProduct();

        String expectedText = "$99.95 USD";
        String actualText = productDetailPage.checkProductPrice();
        Assert.assertEquals(actualText, expectedText);

    }


}
