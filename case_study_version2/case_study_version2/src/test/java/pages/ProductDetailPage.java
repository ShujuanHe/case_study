package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;
    By productPrice = By.className("product-price-minimum money notranslate");
    By productSize = By.xpath("//input[@value='12-18 Months']");
    By productColor = By.xpath("//input[@value='pink']");
    By productQty = By.id("//input[@id='ispbxii_1']");
    By addToCartBtn = By.xpath("//input[@value='Add to cart']");
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkProductPrice(){
        return driver.findElement(productPrice).getText();
    }
    public void setProductSize(){
        driver.findElement(productSize).click();
    }
    public void setProductColor(){
        driver.findElement(productColor).click();
    }
    public void setProductQty(String qty){
        driver.findElement(productQty).sendKeys(qty);
    }
    public void clickAddToCart(){
        driver.findElement(addToCartBtn).click();

    }



}
