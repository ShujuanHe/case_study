package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


    private WebDriver driver;
    By searchButton = By.xpath("/html/body/div[4]/section/header/div[2]/div[3]/form/input[2]");
    By searchPlaceHolder = By.xpath("//input[@placeholder='Search']");
    //For ProductDetailPage
    By productPath = By.xpath("//*[@id=\"shopify-section-section-2\"]/section/div/article[1]/figure");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickAccountBtn(){
        clickLink("Account");
        return new LoginPage(driver);
    }

    //This methods is for search function

    public SearchPage clickSearchBtn(String arg){
        WebElement searchAction = driver.findElement(searchPlaceHolder);
        searchAction.sendKeys(arg);
        searchAction.sendKeys(Keys.ENTER);

        //driver.findElement(searchButton).submit();
        return new SearchPage(driver);
    }

    //product detail page
    public ProductDetailPage clickAnyProduct(){
        driver.findElement(productPath).click();

        return new ProductDetailPage(driver);
    }





}