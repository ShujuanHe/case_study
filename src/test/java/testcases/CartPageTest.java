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
    LoginPage loginPageActions;
    ProductDetailPage productDetailPage;
    CartPage cartPageActions;


    /**
     * TC - 0011 Add Product to the cart and verify if product Is added to cart page
     * Test data: For login in-
     * Email:shujuanhe1@gmail.com
     * Password: 12345
     * <p>
     * Expected result: Selected products should be added to the cart.
     * Test status: Passed
     *
     * @throws Exception
     */
    @Test(priority = 1)
    public void testAddToCart() throws Exception {

        loginPageActions = homePage.clickAccountBtn();
        test.log(Status.INFO, "Login Page is opened!");
        loginPageActions.setEmailField("shujuanhe1@gmail.com");
        loginPageActions.setPasswordField("691122");
        test.log(Status.INFO, "Valid Email and password is entered!");
        customerLoggedInPage = loginPageActions.clickLoginButton();
        test.log(Status.INFO, "Welcome Page is opened!");
        Thread.sleep(30000);

        customerLoggedInPage.returnToHomePage();
        test.log(Status.INFO, "Returned to Home page");
        Thread.sleep(2000);

        productDetailPage = homePage.clickAnyProduct();
        test.log(Status.INFO, "Product detail page is opened");
        /**ProductDetailPage actions
         **/
        productDetailPage.setProductSize();
        productDetailPage.setProductColor();
        test.log(Status.INFO, "Product property is set- Product Size, Product Color");
        Thread.sleep(2000);
        //productDetailPage.waitListenerForAddToCart();
        productDetailPage.clickAddToCart();
        Thread.sleep(500);

        test.log(Status.INFO, "Product is added to Cart");
        Thread.sleep(10000);

        cartPageActions = productDetailPage.clickCartBtn();

        String expectedURL = "https://www.alexandnova.com/cart";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }


    /**
     * TC - 0012 Refresh the page and verify if items are still present in the cart
     * Expected result: Selected products should be still in the cart.
     * Test status: Passed
     *
     * @throws Exception
     */
    @Test(priority = 2)
    public void testRefreshCart() throws IOException, InterruptedException {

        cartPageActions = productDetailPage.clickCartBtn();
        test.log(Status.INFO, "Cart Page is opened!");
        Thread.sleep(1000);

        String expectedMess = "$99.95 USD";
        String actualMess = cartPageActions.getProductPrice();
        Assert.assertEquals(actualMess, expectedMess);

    }

    /**
     * TC - 0013 Increase the quantity of the product and verify if it is showing up in cart
     * Expected result: Selected products should be added to the cart with new quantity.
     * <p>
     * Test data: qty: 2
     * Test status: Passed
     *
     * @throws Exception
     */
    @Test(priority = 3)
    public void testAddQty() throws Exception {
        cartPageActions = productDetailPage.clickCartBtn();
        test.log(Status.INFO, "Cart Page is opened!");
        Thread.sleep(1000);

        cartPageActions.addProductQty("2");
        test.log(Status.INFO, "2 is entered in Qty placeholder");
        Thread.sleep(4000);

        String expectedMess = "$199.90 USD";
        String actualMess = cartPageActions.getProductPrice();
        Assert.assertEquals(actualMess, expectedMess);

    }

    /**
     * TC-0014 Verify Quantity of the products matches with amount displayed in cart
     * Test data: qty: 3
     * Test status: Passed
     *
     * @throws Exception
     */
    @Test(priority = 4)
    public void testQtyMatchesPrice() throws Exception {
        cartPageActions = productDetailPage.clickCartBtn();
        test.log(Status.INFO, "Cart Page is opened!");
        Thread.sleep(1000);
        cartPageActions.addProductQty("3");
        test.log(Status.INFO, "3 is entered in Qty placeholder");
        Thread.sleep(4000);
        String expectedMess = "$299.85 USD";
        String actualMess = cartPageActions.getProductPrice();
        Assert.assertEquals(actualMess, expectedMess);

    }

    /**
     * TC-0015 Verify Remove Product from cart: Verify that the Product should be removed from the cart and the Cart icon should show 0 items.
     * Test status: Passed
     *
     * @throws Exception
     */
    @Test(priority = 5)
    public void testRemoveFromCart() throws Exception {
        cartPageActions = productDetailPage.clickCartBtn();
        test.log(Status.INFO, "Cart Page is opened!");
        Thread.sleep(1000);

        cartPageActions.setRemoveProduct();
        Thread.sleep(4000);

        String expectedMessage = "You don't have any items in your cart yet. Continue shopping .";
        String actualMessage = cartPageActions.getEmptyCartMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
