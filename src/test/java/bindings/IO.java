package bindings;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.Given;

public class IO {

    WebDriver chromeDriver = new ChromeDriver();

    @Given("^that I am one the IO webpage$")
    public void thatIAmOneTheIOWebpage() {
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.navigate().to("https://viki-sinel.github.io/iciclesorganizer/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Then("^I navigate to imventory$")
    public void iNavigateToImventory() {
        chromeDriver.findElement(By.xpath("//a[contains(text(),'Inventory')]")).click();
    }
}
