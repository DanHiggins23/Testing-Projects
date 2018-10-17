import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    @FindBy(xpath = "//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
    private WebElement softwareText;

    public WebElement getSearch() {
        return softwareText;
    }
}
