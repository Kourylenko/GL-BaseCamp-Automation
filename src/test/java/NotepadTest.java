import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
        driver.findElement(By.id("edit_title")).sendKeys("Hello Yaroslav and Oleksandr!");

        driver.findElement(By.id("btnSaveNote")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert, alert-warning"), "You have saved your note as a"));
        driver.findElement(By.cssSelector(".delete")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();


        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("savedNotes"), "No note here."));
   }

   @After
   public void closeBrowser()
   {
       driver.quit();
   }
}
