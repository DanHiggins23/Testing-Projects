import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username")
    private WebElement usernameBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
    private WebElement searchText;

    public void enterDetails(String text1, String text2) throws InterruptedException {
        usernameBox.sendKeys(text1);
        passwordBox.sendKeys(text2);

        passwordBox.submit();
    }

    public WebElement searchText() {
        return searchText;
    }
}
