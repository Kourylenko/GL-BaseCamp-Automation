import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Notepad;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static objects.Notepad.*;

public class NotepadTest {


   WebDriver driver;
   Notepad notePad;

   @Before
   public void openBrowser()
   {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       notePad = new Notepad(driver);
   }

   @Test
   public void loadTest()
   {
       String title = "My New Note";
       String note = "Hello!";
       notePad.open()
               .setTitle(title)
               .setContent(note)
               .save();

       Assert.assertEquals(note,notePad.getNoteTitle());
       Assert.assertEquals(note,notePad.getNoteContent());

       notePad.delete();
   }

   @After
   public void closeBrowser()
   {
       driver.quit();
   }
}
