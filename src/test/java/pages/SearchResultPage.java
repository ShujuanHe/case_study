package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;
    private By productDesc = By.xpath("/html/body/div[7]/div[2]/div[3]/div[5]/ul/li[1]/div[2]/a/div");
    private By productImg = By.xpath("//*[@id=\"isp_search_results_container\"]/li[1]/div[1]/a[1]/img");
    private By babyShoesText = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1/span[2]");
    private By noResult = By.xpath("//*[@id=\"isp_search_results_container\"]/li[1]");


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductDesc(){
        return driver.findElement(productDesc).getText();

    }

    public boolean getProductImg(){
       return driver.findElement(productImg).isDisplayed();

    }
    public boolean getbabyShoesText(){
        return driver.findElement(babyShoesText).isDisplayed();

    }
    public boolean getNoResultText(){
        return driver.findElement(noResult).isDisplayed();

    }



}
