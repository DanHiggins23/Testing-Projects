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

public class SubmitText {
    public WebDriver driver = null;

    //Initilize reports and set path
    ExtentReports report = new ExtentReports("/Users/DanHiggins/Desktop/Reports/demo_site_report.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/DanHiggins/Desktop/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void enterDetails() throws InterruptedException, IOException {
        //Start test
        test = report.startTest("Create a user and ensure that they can login");

        //Creates a new user using below details
        driver.get("http://thedemosite.co.uk/savedata.php");
        test.log(LogStatus.INFO,"Test started");

        CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
        newUser.createUser("dan123", "pass123");
        test.log(LogStatus.INFO, "User created");

        //Directs to the login page and logs in with created details
        driver.get("http://thedemosite.co.uk/login.php");
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.enterDetails("dan123", "pass123");
        test.log(LogStatus.INFO, "User attempting to log in");

        if (login.searchText().getText().equals("**Successful Login**")) {
            test.log(LogStatus.PASS, "User successfully logged in");
        } else {
            test.log(LogStatus.FAIL, "User failed to login");
        }

        report.endTest(test);
        Thread.sleep(500);
        assertEquals("**Successful Login**", login.searchText().getText());
    }

    @After
    public void teardown() {
        report.flush();
        driver.quit();
    }
}
