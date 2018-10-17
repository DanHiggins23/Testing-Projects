import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class SubmitText {
    public static WebDriver driver = null;

    //Initilize reports and set path
    static ExtentReports report = new ExtentReports("/Users/DanHiggins/Downloads/Reports/demo_site_report.html", true);

    ExtentTest test;
    ExtentTest test2;

    @BeforeClass
    public static void starter() {
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

    @Test
    public void checkTitle() throws InterruptedException, IOException{
        //Start test
        test2 = report.startTest("Ensure that the correct page is opening");

        driver.get("http://thedemosite.co.uk/login.php");
        test2.log(LogStatus.INFO, "Browser opened");

        if (driver.getTitle().equals("Login example page to test the PHP MySQL online system")) {
            test2.log(LogStatus.PASS, "Test passed");
        } else {
            test2.log(LogStatus.FAIL, "Test failed");
        }

        report.endTest(test2);
        assertEquals("Login example page to test the PHP MySQL online system", driver.getTitle());
    }

//    @After
//    public void teardown() {
//        report.flush();
//    }

    @AfterClass
    public static void finisher() {
        report.flush();
        driver.quit();
    }
}
