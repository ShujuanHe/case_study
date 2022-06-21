package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    By searchButton = By.xpath("/html/body/div[4]/section/header/div[2]/div[3]/form/input[2]");
    By searchPlaceHolder = By.xpath("//input[@placeholder='Search']");
    //For ProductDetailPage //*[@id="shopify-section-section-2"]/section/div/article[1]/figure
    By productPath = By.xpath("//*[@id=\"shopify-section-section-2\"]/section/div/article[1]/figure");
    By cartButton = By.xpath("/html/body/div[2]/section/header/div[1]/div/div[2]/div[2]/a");

    //HomePage constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    //Navigate to Login page
    public LoginPage clickAccountBtn() {
        clickLink("Account");
        return new LoginPage(driver);
    }

    //Navigate to CartPage
    public CartPage clickCartBtn() {
        clickLink("Cart");
        return new CartPage(driver);
    }

    //Navigate to CheckOutPage
    public CheckOutPage clickCheckOutBtn() {
        clickLink("Checkout");
        return new CheckOutPage(driver);
    }

    //Here Accept parameters to navigate to specific searchResultPage
    public SearchResultPage clickSearchBtn(String arg) {
        WebElement searchAction = driver.findElement(searchPlaceHolder);
        searchAction.sendKeys(arg);
        searchAction.sendKeys(Keys.ENTER);
        //OR --driver.findElement(searchButton).submit();
        return new SearchResultPage(driver);
    }

    //Navigate to productDetailPage
    public ProductDetailPage clickAnyProduct() {
        driver.findElement(productPath).click();
        return new ProductDetailPage(driver);
    }
}