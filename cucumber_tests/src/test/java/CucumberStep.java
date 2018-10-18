import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class CucumberStep {
    public WebDriver driver = null;

    @Before
    public void setup() {
        //Start driver
        System.setProperty("webdriver.chrome.driver", "/Users/DanHiggins/Desktop/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("^the correct web address$")
    public void the_correct_web_address() {
        //Open webpage and check title
        driver.get("http://www.practiceselenium.com/welcome.html");
        assertEquals("Welcome", driver.getTitle());
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page() {
        //Open webpage and check url
        CucumberSetup setup = PageFactory.initElements(driver, CucumberSetup.class);
        setup.getMenu().click();

        assertEquals("Menu", driver.getTitle());
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() {
        CucumberSetup setup = PageFactory.initElements(driver, CucumberSetup.class);
        assertEquals(setup.getGreenTea(), driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000453230000")));
        assertEquals(setup.getRedTea(), driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000453231072")));
        assertEquals(setup.getOolongTea(), driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000453231735")));
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() {
        //Open menu and click checkout button
        CucumberSetup setup = PageFactory.initElements(driver, CucumberSetup.class);
        setup.getCheckoutLink().click();
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() throws Throwable {
        //Ensure that checkout page has been opened
        assertEquals("Check Out", driver.getTitle());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
