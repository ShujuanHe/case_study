package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectBrowser {

    static WebDriver driver;

    public static WebDriver StartBrowser(String browserName) {
        // ---If the browser is Firefox----
        if (browserName.equalsIgnoreCase("Firefox")) {

            System.setProperty("webdriver.firefox.marionette", "C:\\Users\\shuju\\Automation Testing\\Case study_httpswww.alexandnova.com\\case_study_version2\\case_study_version2\\case_study_version2\\src\\test\\resources\\geckodriver.exe");

            driver = new FirefoxDriver();
        }
        //---- If the browser is Chrome--
        else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\shuju\\Automation Testing\\SBAReview (1)\\SBAReview\\src\\test\\resources\\chromedriver.exe");

            driver = new ChromeDriver();

        }

        // ----If the browser is  EdgeIE----

        else if (browserName.equalsIgnoreCase("EdgeExplore")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\shuju\\Automation Testing\\Case study_httpswww.alexandnova.com\\case_study_version2\\case_study_version2\\case_study_version2\\src\\test\\resources\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);

        }
        driver.manage().window().maximize();
        return driver;


    }
}
