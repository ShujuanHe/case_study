package testcases;

import com.aventstack.extentreports.Status;
import library.SelectBrowser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class CartPageTest extends BaseTests {

    CustomerLoggedInPage customerLoggedInPage;
    LoginPage loginPage;
    ProductDetailPage productDetailPage;
    CartPage cartPageActions;

    @Test(priority = 1)
    public void testAddToCart() throws IOException, InterruptedException {

        loginPage = homePage.clickAccountBtn();
        loginPage.setEmailField("shujuanhe1@gmail.com");
        loginPage.setPasswordField("691122");
        Thread.sleep(500);
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

        productDetailPage.clickOnCartBtn();
        Thread.sleep(1000);

        String expectedURL = "https://www.alexandnova.com/cart";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }


    @Test(priority = 2)
    public void testRefreshCart() throws IOException, InterruptedException {

        cartPageActions = productDetailPage.clickOnCartBtn();
        Thread.sleep(1000);

        String expectedMess = "$99.95 USD";
        String actualMess = cartPageActions.getProductPrice();
        Assert.assertEquals(actualMess, expectedMess);

    }

    //TC-0013
    @Test(priority = 3)
    public void testAddQty() throws IOException, InterruptedException {
        cartPageActions = productDetailPage.clickOnCartBtn();
        Thread.sleep(1000);

        cartPageActions.addProductQty("2");
        Thread.sleep(4000);

        String expectedMess = "$199.90 USD";
        String actualMess = cartPageActions.getProductPrice();
        Assert.assertEquals(actualMess, expectedMess);

    }

    //TC-0014
    @Test(priority = 4)
    public void testQtyMatchesPrice() throws IOException, InterruptedException {
        CartPage cartPageActions = productDetailPage.clickOnCartBtn();
        Thread.sleep(1000);
        cartPageActions.addProductQty("3");
        Thread.sleep(4000);
        String expectedMess = "$299.85 USD";
        String actualMess = cartPageActions.getProductPrice();
        Assert.assertEquals(actualMess, expectedMess);

    }

    @Test(priority = 5)
    public void testRemoveFromCart() throws IOException, InterruptedException {
        CartPage cartPageActions = productDetailPage.clickOnCartBtn();
        Thread.sleep(1000);

        cartPageActions.setRemoveProduct();
        Thread.sleep(4000);

        String expectedMessage = "You don't have any items in your cart yet. Continue shopping .";
        String actualMessage = cartPageActions.getEmptyCartMessage();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
