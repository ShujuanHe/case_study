package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    WebDriver driver;
    By payNowBtn = By.xpath("//*[@id=\"continue_button\"]");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String findPayNowBtn(){
       String payNowtext = driver.findElement(payNowBtn).getText();
       return payNowtext;
    }
    public void moveToPayNowBtn() {
        WebElement goToPayNowBtn = driver.findElement(payNowBtn);
        //Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", goToPayNowBtn);

    }
}
