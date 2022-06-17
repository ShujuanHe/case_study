package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

import java.io.IOException;

public class SearchPageTest extends BaseTests{


    HomePage searchRelatedInHome;
    @Test(priority = 1)
    public void testSuccessfulSearch() throws IOException {

       searchRelatedInHome = new HomePage(driver);

        //very inmportant, connect two class, passdown driver

        SearchPage searchResultPage = searchRelatedInHome.clickSearchBtn("baby shoes");

        String expectedURL = "https://www.alexandnova.com/pages/search-results?q=baby%20shoes";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,actualURL);

    }
    @Test(priority = 1)
    public void testSuccessfulSearchBlank() throws IOException {

        searchRelatedInHome = new HomePage(driver);

        //very inmportant, connect two class, passdown driver

        SearchPage searchResultPage = searchRelatedInHome.clickSearchBtn("");

        String expectedURL = "https://www.alexandnova.com/pages/search-results?q=";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,actualURL);

       /* String expectProductDesc = "Cool Kids Summer Baby Sandals";
        String actualProductDesc = searchResultPage.getProductDesc();
        Assert.assertEquals(actualProductDesc,expectProductDesc);*/


    }
}
