import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import objects.Notepad;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotepadTest {

   WebDriver driver;
   Notepad notePad;

   @BeforeClass
   public void openBrowser()
   {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       notePad = new Notepad(driver);
   }

   @Test
   @DisplayName("GL 457,460: Create, Save, Delete notes for an unregistered user")
   public void testCreateAndDeleteNote()
   {
       String title = "My New Note";
       String note = "Hello!";
       notePad.open()
               .setTitle(title)
               .setContent(note)
               .saveNote();
       Assert.assertEquals(title,notePad.getNoteTitle());
       Assert.assertEquals(note,notePad.getNoteContent());

       notePad.deleteNote();
   }

    @Test
    @DisplayName("GL-477:Create a free account")
    public void testCreateNewAccount()
    {
        String email = "Test@gmail.com";
        String password = "12345";
        notePad.open()
                .clickRegisterLoginMenuBtn()
                .fillEmailFieldRegister(email)
                .fillPasswordFieldRegister(password);
        Assert.assertEquals(email,notePad.getEmailRegisterField());

        notePad.clickCreateAccountButton();
    }

    @Test
    @DisplayName("GL-496:Successful login in an existing account")
    public void testLogin()
    {
        String login = "Test@gmail.com";
        String pass = "test";
        notePad.open()
                .clickRegisterLoginMenuBtn()
                .fillEmailFieldLogin(login)
                .fillPasswordFieldLogin(pass);
        Assert.assertEquals(login,notePad.getEmailLoginField());
        notePad.clickLoginButton();
    }

   @After
   public void closeBrowser()
   {
       driver.quit();
   }
}
