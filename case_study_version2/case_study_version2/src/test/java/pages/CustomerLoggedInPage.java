package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoggedInPage {

    private WebDriver driver;
    private By statusAlert = By.xpath("/html/body/div[3]/h1");
    private By checkBox = By.id("recaptcha-anchor");
    private By editorIframeId = By.xpath("/html/body/div[3]/div/form/div/div/div/iframe");
    private By errorMessage = By.xpath("/html/body/div[3]/div[2]/div[1]/form/p");

    public CustomerLoggedInPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
    public void clickCheckBox(){
        switchToEditArea();
        driver.findElement(checkBox).click();
        switchToMainArea();

    }
    public void switchToEditArea(){
        driver.switchTo().frame(driver.findElement(editorIframeId));
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();

    }

}
