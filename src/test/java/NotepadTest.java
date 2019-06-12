import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NotepadTest {


   WebDriver driver;
   WebDriverWait wait;


   @Before
    public void openBrowser()
   {
       WebDriverManager.chromedriver().setup();

       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 5);
   }

   @Test
    public void loadTest()
   {
        driver.get("https://anotepad.com/");
        driver.findElement(By.id("edit_title")).sendKeys("My New Note");

        driver.findElement(By.id("btnSaveNote")).click();

        driver.findElement(By.id("edit_textarea")).sendKeys("Hello Yaroslav and Oleksandr!");
        driver.findElement(By.id("btnSaveNote")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert, alert-warning")));


   }

//   @After
//    public void closeBrowser()
//   {
//       driver.quit();
//   }
}
