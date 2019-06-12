import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotepadTest {


   WebDriver driver;

   @Before
    public void openBrowser()
   {
       WebDriverManager.chromedriver().setup();

       driver = new ChromeDriver();
   }

   @Test
    public void loadTest()
   {

   }

   @After
    public void closeBrowser()
   {
       driver.quit();
   }
}
