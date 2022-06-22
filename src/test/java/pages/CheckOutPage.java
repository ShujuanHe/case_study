package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    WebDriver driver;
    // private  By giftCardOrDiscountCode = By.xpath("/html/body/div/div/div/main/div[1]/div/div[2]/div[2]/div/form[2]/div/div/div/div/input");
    private  By giftCardOrDiscountCode = By.id("checkout_reduction_code");
    private By payNowBtn = By.xpath("//*[@id=\"continue_button\"]");
    private By discountInvalidMessage = By.xpath("//*[@id=\"order-summary\"]/div/div[2]/form[1]/div/svg/use");
    private By creditCards = By.xpath("/html/body/div/div/div/main/div[1]/div/form/div[1]/div[2]/div[2]/fieldset/div[1]/div[2]/div/ul");
    private By shopPay = By.xpath("/html/body/div/div/div/main/div[1]/div/form/div[1]/div[2]/div[2]/fieldset/div[4]/div[2]/label/img");
    private By payPal = By.xpath("/html/body/div/div/div/main/div[1]/div/form/div[1]/div[2]/div[2]/fieldset/div[6]/div[2]/label/img");
    private By errorTextForValidation = By.xpath("/html/body/div/div/div/main/div[1]/div/form/div[1]/div[2]/div[2]/div/p");
    //private By continueToPayment = By.xpath("/html/body/div/div/div/main/div[1]/div/form/div[1]/div[2]/div[2]/div/p");
    //private By continueToPayment = By.className("icon-svg icon-svg--size-18 btn__spinner icon-svg--spinner-button");
    private By continueToPayment = By.id("continue_button");
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkDiscountCode(String discountCode){
        driver.findElement(giftCardOrDiscountCode).sendKeys(discountCode);
        driver.findElement(giftCardOrDiscountCode).sendKeys(Keys.ENTER);

    }
    public String getInvalidDiscountText(){
        return driver.findElement(discountInvalidMessage).getText();


    }
    public String findPayNowBtn(){
       String payNowtext = driver.findElement(payNowBtn).getText();
       return payNowtext;
    }
    public void clickPayNowBtn() {
       driver.findElement(payNowBtn).click();

    }

    public void moveToPayNowBtn() {
        WebElement goToPayNowBtn = driver.findElement(payNowBtn);
        //Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", goToPayNowBtn);

    }
    public boolean checkCreditCardsIsDisable(){
        return driver.findElement(creditCards).isDisplayed();
    }
    public boolean checkShopPayIsDisable(){
        return driver.findElement(shopPay).isDisplayed();
    }
    public boolean checkPayPalIsDisable(){
        return driver.findElement(payPal).isDisplayed();
    }
    public boolean getErrorTextForValidation(){
        return driver.findElement(errorTextForValidation).isDisplayed();
    }

    public void clickContinueToPayment(){
        driver.findElement(continueToPayment).click();
    }

    public WebElement waitListener(){


         return driver.findElement(continueToPayment);



    }
}
