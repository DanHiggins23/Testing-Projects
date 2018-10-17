import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class WaitTest {
    public WebDriver driver = null;
    ExtentReports report = new ExtentReports("/Users/DanHiggins/Downloads/Reports/wait_tests_report.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/DanHiggins/Desktop/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void hateText() {
        //Start test
        test = report.startTest("Check for xpath after explicit timeout");

        driver.get("https://chrisperrins95.github.io/AutomatedTestingExample/");
        test.log(LogStatus.INFO, "Browser opened");

        ///Initializing WaitPage and passing driver
        test.log(LogStatus.INFO, "Applying timeout and searching for result");
        WaitPage waitPage = PageFactory.initElements(driver, WaitPage.class);

        if (waitPage.hateText(driver).getText().equals("I HATE YOU!\n-The Shafeeq")) {
            test.log(LogStatus.PASS, "Test passed successfully");
        } else {
            test.log(LogStatus.FAIL, "Test failed");
        }

        report.endTest(test);
        assertEquals("I HATE YOU!\n-The Shafeeq", waitPage.hateText(driver).getText());
    }

    @After
    public void teardown() {
        report.flush();
        driver.quit();
    }
}