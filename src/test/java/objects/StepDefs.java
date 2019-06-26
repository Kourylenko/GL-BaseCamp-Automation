package objects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefs {

    private WebDriver driver;
    private WebDriverWait wait;

    public StepDefs(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }
    @Given("Notepad is opened in Chrome browser")
    public void notepadIsOpenInChromeBrowser()
    {
        driver.get("https://anotepad.com/");
    }

    @When("I entered text in Note Title field")
    public void iEnterTextInNoteTitleField(String noteTitle)
    {
        driver.findElement(By.xpath("//*[@id='edit_title']")).sendKeys("Note Title");
    }

    @And("I clicked Save button")
    public void iClickSaveButton()
    {
        driver.findElement(By.xpath("//*[@id='btnSaveNote']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert.alert-warning"), "You have saved your note as a"));

    }
}
