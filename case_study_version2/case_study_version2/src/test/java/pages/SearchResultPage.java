package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;
    By productDesc = By.xpath("/html/body/div[7]/div[2]/div[3]/div[5]/ul/li[1]/div[2]/a/div");


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductDesc(){
        return driver.findElement(productDesc).getText();

    }



}
