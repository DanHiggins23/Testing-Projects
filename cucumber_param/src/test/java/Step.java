import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class Step {
    String fullTitle = "";

    public WebDriver driver = null;

    @Before
    public void setup() {
        //Start driver
        System.setProperty("webdriver.chrome.driver", "/Users/DanHiggins/Desktop/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("^I go to \"([^\"]*)\" website$")
    public void i_go_to_website(String arg1) {
        //Open window by passing argument from feature file
        driver.get(arg1);
    }

    @When("^I search for \"([^\"]*)\" searchTerm$")
    public void i_search_for_searchTerm(String arg1) {
        //Store argument in variable to comapre against title element
        fullTitle = arg1 + " - Bing";

        SearchPage spage = PageFactory.initElements(driver, SearchPage.class);
        spage.search(arg1);
    }

    @Then("^I am taken to a list of data for that search$")
    public void i_am_taken_to_a_list_of_data_for_that_search() {
        //Bing uses search term + "- Bing" for the title. This will check if they're the same
        assertEquals(fullTitle, driver.getTitle());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
