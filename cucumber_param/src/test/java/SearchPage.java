import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    @FindBy(id = "sb_form_q")
    private WebElement searchBox;

    public void search(String searchQuery) {
        searchBox.sendKeys(searchQuery);
        searchBox.submit();
    }
}
