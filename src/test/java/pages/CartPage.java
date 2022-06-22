package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;
    ////*[@id="shopify-section-cart"]/section/form/table/tbody/tr/td[4]/span/span
    //By productPrice = By.xpath("/html/body/div[3]/div/section/form/table/tbody/tr/td[4]/span/span");
    By productPrice = By.xpath("//*[@id=\"shopify-section-cart\"]/section/form/table/tbody/tr/td[4]/span/span");
    By productQty = By.xpath("//*[@id=\"updates_30882853224501\"]");
    By removeProduct = By.xpath("//*[@id=\"shopify-section-cart\"]/section/form/table/tbody/tr/td[1]/a[2]");
    By emptyCart = By.xpath("/html/body/div[3]/div/section/p");
    By checkoutBtn = By.xpath("//*[@id=\"shopify-section-cart\"]/section/form/div/div/div[2]/button");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductPrice(){
        return driver.findElement(productPrice).getText();
    }
    public void addProductQty(String qty){
        driver.findElement(productQty).clear();
        driver.findElement(productQty).sendKeys(qty);
        driver.findElement(productQty).sendKeys(Keys.ENTER);

    }

    public void setRemoveProduct(){
        driver.findElement(removeProduct).click();
    }

    public String getEmptyCartMessage(){
        return driver.findElement(emptyCart).getText();

    }
    public CheckOutPage navigateToCheckoutPage(){
        driver.findElement(checkoutBtn).click();
        return new CheckOutPage(driver);
    }



}
