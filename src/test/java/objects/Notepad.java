package objects;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notepad {

    private static final By noteTitle = By.id("edit_title");
    private static final By noteContent = By.id("edit_textarea");
    private static final By saveNoteButton = By.id("btnSaveNote");
    private static final By deleteNoteButton = By.cssSelector(".delete");

    private WebDriver driver;
    private WebDriverWait wait;
    public Notepad (WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }
    @Step
    public Notepad open()
    {
        driver.get("https://anotepad.com/");
        return this;
    }

    @Step
    public Notepad setTitle(String title)
    {
        driver.findElement(noteTitle).sendKeys(title);
        return this;
    }

    @Step
    public Notepad setContent(String content)
    {
        driver.findElement(noteContent).sendKeys(content);
        return this;
    }

    @Step
    public Notepad save()
    {
        driver.findElement(saveNoteButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert, alert-warning"), "You have saved your note as a"));
        return  this;
    }

    @Step
    public String getNoteTitle()
    {
        return driver.findElement(noteTitle).getAttribute("value");
    }

    @Step
    public String getNoteContent()
    {
        return driver.findElement(noteContent).getAttribute("value");
    }

    @Step
    public Notepad delete()
    {
        driver.findElement(deleteNoteButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("savedNotes"), "No note here."));
        return  this;
    }

}
