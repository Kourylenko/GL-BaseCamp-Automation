package ObjectsForUnregisteredUser;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notepad {

    //    testCreateNewAccount

    private static final By emailRegisterField = By.xpath("//*[@id='registerEmail']");
    private static final By passwordRegisterField = By.xpath("//input[@placeholder='New Password']");
    private static final By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

        //    testLoginInAccount
    private static final By registerLoginBtn = By.xpath("//span[contains(text(),'Register/Login')]");
    private static final By emailLoginField = By.xpath("//*[@id='loginEmail']");
    private static final By passwordLoginField = By.xpath("//input[@placeholder='Enter Password']");
    private static final By loginButton = By.xpath("//button[contains(text(),'Login')]");

    //    testCreateAndDeleteNote
    private static final By noteTitle = By.xpath("//*[@id='edit_title']");
    private static final By noteContent = By.xpath("//*[@id='edit_textarea']");
    private static final By saveNoteButton = By.xpath("//*[@id='btnSaveNote']");
    private static final By deleteNoteButton = By.xpath("//*[@class='delete']");

    private WebDriver driver;
    private WebDriverWait wait;

    public Notepad (WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    //    testCreateNewAccount
    @Step
    public Notepad clickRegisterLoginMenuBtn()
    {
        driver.findElement(registerLoginBtn).click();
        return this;
    }
    @Step
    public Notepad fillEmailFieldRegister(String email)
    {
        driver.findElement(emailRegisterField).clear();
        driver.findElement(emailRegisterField).sendKeys(email);
        return this;
    }
    @Step
    public Notepad fillPasswordFieldRegister(String password)
    {
        driver.findElement(passwordRegisterField).clear();
        driver.findElement(passwordRegisterField).sendKeys(password);
        return this;
    }
    @Step
    public String getEmailRegisterField()
    {
        return driver.findElement(emailRegisterField).getAttribute("value");
    }
    @Step
    public Notepad clickCreateAccountButton()
    {
        driver.findElement(createAccountButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='alert alert-danger']"), "Email also exists in system. Please Login."));
        return this;
    }

    //    testLoginInAccount

    @Step
    public Notepad fillEmailFieldLogin(String login)
    {
        driver.findElement(emailLoginField).clear();
        driver.findElement(emailLoginField).sendKeys(login);
        return this;
    }
    @Step
    public Notepad fillPasswordFieldLogin(String pass)
    {
        driver.findElement(passwordLoginField).clear();
        driver.findElement(passwordLoginField).sendKeys(pass);
        return this;
    }
    @Step
    public Notepad clickLoginButton()
    {
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Settings')]")));
        return this;
    }
    @Step
    public String getEmailLoginField()
    {
        return driver.findElement(emailLoginField).getAttribute("value");
    }

    //    testCreateAndDeleteNote

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
    public Notepad saveNote()
    {
        driver.findElement(saveNoteButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='alert alert-danger']"), "You have saved your note as a"));
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
    public Notepad deleteNote()
    {
        driver.findElement(deleteNoteButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='savedNotes']"), "No note here."));
        return  this;
    }

}



