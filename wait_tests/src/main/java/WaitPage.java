import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPage {
    public WebElement hateText(WebDriver driver) {
        //Setting timeouts and passing driver from test class
        WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("shafeeq")));
        return element;
    }
}
