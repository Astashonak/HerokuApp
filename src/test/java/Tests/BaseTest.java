package Tests;

import Pages.ContextMenuPage;
import Pages.DragAndDropPage;
import Pages.FileUploaderPage;
import Pages.JavaScriptAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    FileUploaderPage fileUploaderPage;
    DragAndDropPage dragAndDropPage;
    ContextMenuPage contextMenuPage;
    JavaScriptAlertsPage javaScriptAlertsPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        fileUploaderPage = new FileUploaderPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    }

    @AfterMethod(alwaysRun=true)
    public void closeBrowser() {
        driver.quit();
    }
}
