import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
    @FindBy(name = "username")
    private WebElement createUsername;

    @FindBy(name = "password")
    private WebElement createPassword;

    public void createUser(String createUser, String createPass) throws InterruptedException {
        createUsername.sendKeys(createUser);
        createPassword.sendKeys(createPass);

        createPassword.submit();
    }
}
