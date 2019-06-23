package ObjectsForRegisteredUser;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredUser {



    //    testLoginInAccount
    private static final By registerLoginBtn = By.xpath("//span[contains(text(),'Register/Login')]");
    private static final By emailLoginField = By.xpath("//*[@id='loginEmail']");
    private static final By passwordLoginField = By.xpath("//input[@placeholder='Enter Password']");
    private static final By loginButton = By.xpath("//button[contains(text(),'Login')]");

    //    testCreateNewFolder
    private static final By manageFolderBtn = By.xpath("//a[contains(text(),'Manage Folders')]");
    private static final By newFolderField = By.xpath("//input[@placeholder='Folder Name']");
    private static final By createNewFolderBtn = By.xpath("//input[@value='Create New']");
    private static final By closeManageFolder = By.xpath("//*[@class='modal in']");

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisteredUser (WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    @Step
    public RegisteredUser open() {
        driver.get("https://anotepad.com/");
        return this;
    }

    // testLogin
    @Step
    public RegisteredUser Login(String login, String pass)
    {
        wait.until(ExpectedConditions.titleIs("https://anotepad.com/"));
        driver.findElement(registerLoginBtn).click();
        driver.findElement(emailLoginField).clear();
        driver.findElement(emailLoginField).sendKeys(login);
        driver.findElement(passwordLoginField).clear();
        driver.findElement(passwordLoginField).sendKeys(pass);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Settings')]")));
        return this;

    }

    //    testCreateNewFolder

    @Step
    public RegisteredUser clickManageFolderBtn()
    {
        driver.findElement(manageFolderBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(newFolderField));
        return this;
    }

    @Step
    public RegisteredUser fillNewFolderField(String folderName)
    {
        driver.findElement(newFolderField).sendKeys(folderName);
        return this;
    }
    @Step
    public String getNewFolderName()
    {
        return driver.findElement(newFolderField).getAttribute("value");

    }

    @Step
    public RegisteredUser clickCreateNewBtn()
    {
        driver.findElement(createNewFolderBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeManageFolder));
        return this;
    }

    @Step
    public RegisteredUser clickCloseManageFolderBtn()
    {
        driver.findElement(closeManageFolder).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),folderName)]")));
        return this;
    }




}









