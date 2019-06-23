import ObjectsForRegisteredUser.RegisteredUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForLoggedInUsers {
    WebDriver driver;
    RegisteredUser registeredUser;


    @Before
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registeredUser = new RegisteredUser(driver);
        registeredUser.Login("Test@gmail.com", "test");
    }


    @Test
    @DisplayName("GL-506:Creating a folder")

    public void testCreateNewFolder()
    {
        String folderName = "New Folder";
        registeredUser.open()
                .clickManageFolderBtn()
                .fillNewFolderField(folderName);
        Assert.assertEquals(folderName,registeredUser.getNewFolderName());
        registeredUser.clickCreateNewBtn()
                .clickCloseManageFolderBtn();
    }


    @After
    public void closeBrowser()
    {
        driver.quit();
    }
}

