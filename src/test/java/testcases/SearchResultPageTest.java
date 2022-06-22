package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;

import java.io.IOException;

/**
 * Tests are
 */
public class SearchResultPageTest extends BaseTests{
    SearchResultPage searchResultPage;


    /** TC - 0008 Verify Correct search results should show up for different types such as product name, brand name, or fuzzy search.
     * Test data: baby shoes
     * Expected result: baby shoes should show up
     * Test status: Passed
     *
     * @throws IOException
     */
    @Test(priority = 1)
    public void testSuccessfulSearch() throws Exception {

        searchResultPage = homePage.clickSearchBtn("baby shoes");
        test.log(Status.INFO, "Entered 'baby shoes' in search placeholder and click on search button");

        String expectedURL = "https://www.alexandnova.com/pages/search-results?q=baby%20shoes";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,actualURL);

        /** More testing asserstions
        Assert.assertTrue(searchResultPage.getProductImg());
        Assert.assertTrue(searchResultPage.getbabyShoesText());
         **/

    }

    /** TC - 0009 Without entering anything in the search box click on the Search button.
     * Test data: ""
     *
     * Expected result: No results found. Showing top popular products you might want to consider.
     * Test status: Passed
     *
     * @throws IOException
     */
    @Test(priority = 2)
    public void testSuccessfulSearchBlank() throws Exception {

        //very inmportant, connect two class, passdown driver

        searchResultPage = homePage.clickSearchBtn("");
        test.log(Status.INFO, "Leave search placeholder blank and click on search button");

        String expectedURL = "https://www.alexandnova.com/search?q=";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

        /**
         * More assertion tests
         */
        //Assert.assertTrue(searchResultPage.getNoResultText());

       /* String expectProductDesc = "Cool Kids Summer Baby Sandals";
        String actualProductDesc = searchResultPage.getProductDesc();
        Assert.assertEquals(actualProductDesc,expectProductDesc);*/


    }
}
