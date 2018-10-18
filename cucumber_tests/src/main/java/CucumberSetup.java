import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CucumberSetup {
    @FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
    private WebElement menu;

    @FindBy (xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
    private WebElement checkoutLink;

    @FindBy (id = "wsb-element-00000000-0000-0000-0000-000453230000")
    private WebElement greenTea;

    @FindBy (id = "wsb-element-00000000-0000-0000-0000-000453231072")
    private WebElement redTea;

    @FindBy (id = "wsb-element-00000000-0000-0000-0000-000453231735")
    private  WebElement oolongTea;

    public WebElement getMenu() {
        return menu;
    }

    public WebElement getCheckoutLink() {
        return checkoutLink;
    }

    public WebElement getGreenTea() {
        return greenTea;
    }

    public WebElement getRedTea() {
        return redTea;
    }

    public WebElement getOolongTea() {
        return  oolongTea;
    }
}
