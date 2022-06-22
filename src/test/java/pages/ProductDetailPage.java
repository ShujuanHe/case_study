package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage {

    private WebDriver driver;
    HomePage homePageActions;
    By productPrice = By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/p/span[1]");
   // By productSize = By.xpath("//input[@value='12-18 Months']");  //*[@id="bcpo-select-option-0"]/div[1]/label
    By productSize = By.xpath(" //*[@id=\"bcpo-select-option-0\"]/div[1]/label");
   // By productColor = By.xpath("//*[@id=\"bcpo-select-option-1\"]/div[1]");
    By productColor = By.xpath("//*[@id=\"bcpo-select-option-1\"]/div[1]/label");
   // By productQty = By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/form/div[1]/input");
   By productQty = By.xpath("//*[@id=\"product_form_2496766902329\"]/div[1]/label");
   // By productQty = By.xpath("//input[@name='quantity']");
    //By addToCartBtn = By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/form/div[4]/input");
   //By addToCartBtn = By.xpath("//*[@id=\"product_form_2496766902329\"]/div[4]/input");
    //Find BY FULL PATH
   By addToCartBtn = By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/form/div[4]/input");
    By homepageLink = By.id("navigation-home");
    By cartButton = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[2]/a");
   // By inputList = By.xpath("//input[@type='radio']");
    By inputList = By.xpath("//*[@tabindex=0]");
    //By checkoutBtn = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/a");
    By checkoutBtn = By.xpath("/html/body/div[3]/div/section/form/div/div/div[2]/button");
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    public void moveToAddToBtns(){
        WebElement goToBtns = driver.findElement(addToCartBtn);
        //Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", goToBtns);

    }

    public void moveToProductQty(){
        WebElement goToProductQty = driver.findElement(productQty);
        //Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", goToProductQty);

    }


    public String checkProductPrice(){
        return driver.findElement(productPrice).getText();
    }
    /*public void setProductSize(){
        //this.moveToBtns(productSize);
        driver.findElement(productSize).click();
    }*/

    public WebElement getInputList(int index){
        List<WebElement> webElementList = driver.findElements(inputList);
        return webElementList.get(index);

    }
     public void setProductSize(){
        driver.findElement(productSize).click();
    }


/**   public void setProductSize(){
       //this.moveToBtns(productSize);
       WebElement months_12_18 = this.getInputList(0);
       months_12_18.click();
   }*/

  public void setProductColor(){
       //this.moveToBtns(productColor);
       driver.findElement(productColor).click();
   }

  /** public void setProductColor(){
       //this.moveToBtns(productColor);
       WebElement color_pink = this.getInputList(10);
       color_pink.click();
   }*/
    public void setProductQty(String qty){
        //this.moveToBtns(productQty);
        driver.findElement(productQty).sendKeys(qty);
    }
    public void clickAddToCart(){
        //this.moveToBtns(addToCartBtn);
        driver.findElement(addToCartBtn).click();

    }
    /** Another way to click on Checkout button on the menu bar to navigate to Checkout page
     *
    public CartPage clickOnCartBtn(){
        driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[2]/a/span[1]")).click();
        return new CartPage(driver);

    }
     **/

    public HomePage returnToHomePage(){
        driver.findElement(homepageLink).click();
        return new HomePage(driver);

    }
    public void waitListener(By options){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productSizeIdx0 = this.getInputList(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(options));
    }
    public void waitListenerForProductSize(){

        this.waitListener(productSize);
    }
    public void waitListenerForProductColor(){

        this.waitListener(productColor);
    }
    public void waitListenerForAddToCart(){

        this.waitListener(addToCartBtn);
    }
   public CartPage clickCartBtn(){
       // this.moveToBtns(cartButton);
        driver.findElement(cartButton).click();

        return new CartPage(driver);
    }



    public CheckOutPage clickOnCheckoutBtn(){
        driver.findElement(checkoutBtn).click();
        return new CheckOutPage(driver);
    }


}
