package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class CustomerLoggedInPage {

    private WebDriver driver;
    private By statusAlert = By.xpath("/html/body/div[3]/h1");
    private By checkBox = By.id("recaptcha-anchor");
    private By editorIframeId = By.xpath("/html/body/div[3]/div/form/div/div/div/iframe");
    private By homepageLink = By.id("navigation-home");
    private By welcomeMassage = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1");
  //  private By errorMessage = By.xpath("/html/body/div[3]/div[2]/div[1]/form/p");

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

    public String getWelcomeMessage(){
        return driver.findElement(welcomeMassage).getText();

    }

    public HomePage returnToHomePage(){
        try {
        driver.findElement(homepageLink).click();
        } catch (WebDriverException e) {

            e.printStackTrace();

        }
        return new HomePage(driver);

    }

 /*   public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();

    }*/

}
