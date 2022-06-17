package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.id("ispbxii_1");
    private By passwordField = By.name("customer[password]");
    private By loginButton = By.xpath("/html/body/div[3]/div[2]/div[1]/form/div[3]/input");
    private By clickRegisterBtn = By.xpath("//*[@id=\"keyboard-nav-3\"]/div[2]/div[3]/a");
    private By emailErrorMessage = By.xpath("/html/body/div[3]/div[2]/div[1]/form/p");



    public RegisterPage clickRegisterBtn(){
        driver.findElement(clickRegisterBtn).click();
        return new RegisterPage(driver);
    }
    public CustomerLoggedInPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new CustomerLoggedInPage(driver);
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String username){
        driver.findElement(emailField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void moveToRegisterBtn(){
        WebElement goToRegisterBtn = driver.findElement(By.xpath("//*[@id=\"keyboard-nav-3\"]/div[2]/div[3]/a"));
        //Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", goToRegisterBtn);

    }

    public String getEmailErrorMessage(){

        return driver.findElement(emailErrorMessage).getText();
    }



}