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
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.Given;


public class AlanApp {
    
    WebDriver chromeDriver = new ChromeDriver();

    @Given("^that I am on the Alan App$")
    public void thatIAmOnTheAlanApp() throws Throwable {
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.navigate().to("https://studio.alan-stage.app/login");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Then("^I enter my email address$")
    public void iEnterMyEmailAddress() {
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement email = chromeDriver.findElement(By.id("email"));
        email.sendKeys(new String[]{"testalanapp5@gmail.com"});
    }

    @And("^I enter my password$")
    public void iEnterMyPassword() {
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement password = chromeDriver.findElement(By.id("password"));
        password.sendKeys(new String[]{"13532464"});
    }

    @Then("^I press login button$")
    public void iPressLoginButton() {
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[3]/button[1]")).click();
    }


    @Then("^I create a new voice assistant$")
    public void iCreateANewVoiceAssistant() {
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]")).click();
    }


    @Then("^I choose an empty project$")
    public void iChooseAnEmptyProject() {
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//body/div[@id='react-confirm-alert']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
    }


    @And("^name it test and create a new project$")
    public void nameItTestAndCreateANewProject() {
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//input[@id='projectName']")).sendKeys(new String[]{"Test"});
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
    }

    @And("^I sync with my github account$")
    public void iSyncWithMyGithubAccount() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
//        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(new String[]{"viki-sinel"});
        chromeDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(new String[]{"13532464.Vika"});
        chromeDriver.findElement(By.xpath("//body/div[3]/main[1]/div[1]/div[3]/form[1]/div[1]/input[12]")).click();
        chromeDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @Then("^I authorize my github account$")
    public void iAuthorizeMyGithubAccount() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            chromeDriver.findElement(By.xpath("//button[@id='js-oauth-authorize-btn']")).click();
        }
    }

    @Then("^I add a repository from my github account$")
    public void iAddARepositoryFromMyGithubAccount() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]")).click();
        chromeDriver.findElement(By.xpath("//body/div[@id='react-confirm-alert']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]")).click();
        chromeDriver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]")).click();
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]")).click();
        chromeDriver.findElement(By.xpath("//div[contains(text(),'Octo-branch')]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//button[contains(text(),'Add files')]")).click();
    }

    @And("^I add a new script and push it back to github$")
    public void iAddANewScriptAndPushItBackToGithub() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/i[1]")).click();
        chromeDriver.findElement(By.xpath("//body/div[@id='react-confirm-alert']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[11]")).click();
        chromeDriver.findElement(By.xpath("//body/div[@id='react-confirm-alert']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//input[@id='message']")).sendKeys("new commit");
        chromeDriver.findElement(By.xpath("//button[contains(text(),'Commit & push')]")).click();
    }

    @Then("^make sure push was successful$")
    public void makeSurePushWasSuccessful() {
        String expected = "Your changes were pushed successfully";
        String actual = chromeDriver.findElement(By.xpath("//body/div[@id='toast-container']/div[1]")).getText();

        if(expected.equals(actual)) {
            System.out.println(actual);
        }

        else {
            System.out.println("GitHub wasn't pushed successfully.");
        }


    }

    @Then("^I log out from studio$")
    public void iLogOutFromStudio() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/i[1]")).click();
        chromeDriver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/span[1]")).click();
    }
}