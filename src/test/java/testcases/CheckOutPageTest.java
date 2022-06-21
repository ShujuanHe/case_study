package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class CheckOutPageTest extends BaseTests{
    LoginPage loginPage;
    CustomerLoggedInPage customerLoggedInPage;
    ProductDetailPage productDetailPage;
    CartPage cartPageActions;
    CheckOutPage checkOutPageActions;



    //TC-0017
    @Test(priority = 1)
    public void testSuccessfulCheckOut() throws IOException, InterruptedException {

        loginPage = homePage.clickAccountBtn();
        loginPage.setEmailField("shujuanhe1@gmail.com");
        loginPage.setPasswordField("691122");
        Thread.sleep(2000);
        CustomerLoggedInPage customerLoggedInPage = loginPage.clickLoginButton();
        Thread.sleep(500);
        customerLoggedInPage.returnToHomePage();
        Thread.sleep(500);

        productDetailPage = homePage.clickAnyProduct();
        /**ProductDetailPage actions
         **/
        productDetailPage.setProductSize();
        productDetailPage.setProductColor();
        Thread.sleep(2000);
        productDetailPage.waitListenerForAddToCart();
        productDetailPage.clickAddToCart();
        Thread.sleep(500);

        //productDetailPage.clickOnCartBtn();
        checkOutPageActions = productDetailPage.clickOnCheckoutBtn();
        Thread.sleep(1000);
        checkOutPageActions.moveToPayNowBtn();
        Thread.sleep(1000);



        String expectedText ="Pay now";
        String actualText = checkOutPageActions.findPayNowBtn();
        Assert.assertEquals(actualText,expectedText);
    }
}
