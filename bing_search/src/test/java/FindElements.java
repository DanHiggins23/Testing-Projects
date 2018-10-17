import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class FindElements {
    public WebDriver driver = null;
    //Initilize test report and add path
    ExtentReports extent = new ExtentReports("/Users/DanHiggins/Desktop/Reports/report.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/DanHiggins/Desktop/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void searchText() throws InterruptedException, IOException {
        //Start the test
        test = extent.startTest("Verify search item appears in Bing");
        driver.get("https://www.bing.com");
        test.log(LogStatus.INFO, "Browser Started");

        LandingPage bingPage = PageFactory.initElements(driver, LandingPage.class);
        SearchPage bingSearch = PageFactory.initElements(driver, SearchPage.class);

        bingPage.search("Selenium");
        test.log(LogStatus.INFO, "Text search run");

        if (bingSearch.getSearch().getText().equals("Selenium")) {
            test.log(LogStatus.PASS, "Verify that search item appears");
        } else {
            test.log(LogStatus.FAIL, "eSearch text was not found");
        }

        //Added to ensure test doesn't quit before text has been found
        Thread.sleep(500);

        extent.endTest(test);
        assertEquals("Selenium", bingSearch.getSearch().getText());
    }

    @After
    public void teardown() {
        extent.flush();
        driver.quit();
    }
}
