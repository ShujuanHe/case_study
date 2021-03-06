package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    private WebDriver driver;
    private By firstNameField = By.id("ispbxii_1");
    private By lastNameField = By.id("ispbxii_2");
    private By emailField = By.id("ispbxii_3");
    private By passwordField = By.xpath("//*[@id=\"create_customer\"]/div[4]/input");
    private By registerBtn = By.xpath("//*[@id=\"create_customer\"]/div[5]/input");
    private By captchaContent = By.xpath("/html/body/div[2]");
    private By checkBox = By.xpath("//*[@id=\"recaptcha-anchor\"]");
    private By captchaSubmit = By.xpath("//*[@id=\"keyboard-nav-3\"]/div/form/input[2]");
    private By myAccount = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[1]/a");

    /**
     * Here is for page factory
     *
     * @FindBy(linkText = "My account")
     * WebElement myAccountLink;
     */


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);

    }

    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);

    }

    public void setEmailField(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

    }

    public void handleCaptcha() {
        driver.switchTo().frame(driver.findElement(captchaContent));
        driver.findElement(checkBox).click();
        driver.findElement(captchaSubmit).click();
        driver.switchTo().parentFrame();

    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

    }

    public CustomerLoggedInPage clickRegister() {
        driver.findElement(registerBtn).click();
        return new CustomerLoggedInPage(driver);
    }

    public boolean myAccountLinkIsDisplayed() {

        return driver.findElement(myAccount).isDisplayed();

    }

    /** Here is for Page factory example
     *  public boolean myAccountLinkIsDisplayed() {

     return myAccountLink.isDisplayed();

     }*/

}
