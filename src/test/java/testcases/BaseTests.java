package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;
    public HomePage homePage;

    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;


    @BeforeSuite
    public void setUpReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/xml/case_study_Report.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "shujuan.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Shujuan He");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Google search test");
        htmlReporter.config().setReportName("Google Search report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeTest
    @Parameters("browserName")
    public void startBrowser(String browserName) {
        driver = SelectBrowser.StartBrowser(browserName);
        //test.log(Status.INFO, "Browser is started!");

    }

    @BeforeMethod
    public void launchBrowser(Method method) throws Exception {
        String methodName = method.getName();
        test = extent.createTest(methodName);
        test.addScreenCaptureFromPath(methodName + ".png");
        //driver = SelectBrowser.StartBrowser("Chrome");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
        homePage = new HomePage(driver);
        //test.log(Status.INFO, "Test is started and Home page is lunched!");


    }

    @AfterMethod
    public void recordTestResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("test-output/xml/" + result.getName() + ".png"));
            test.log(Status.FAIL, result.getThrowable());
          //  extent.endTest(test);
            extent.flush();
           // driver.close();
        }else{
            test.log(Status.INFO, "Test ended!");
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();

    }

  /*  @AfterMethod
    public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("C:\\Users\\shuju\\Automation Testing\\selenium-webdriver-java-course-c8\\webdriver_java\\resources\\screenshot"));
            //System.out.println("Screen taken:" + screenshot.getAbsolutePath());
        }catch(IOException e){
            e.printStackTrace();
        }*/

}