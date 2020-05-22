package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ContextMenuPage;
import pages.DragAndDropPage;
import pages.FileUploaderPage;
import pages.JavaScriptAlertsPage;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    FileUploaderPage fileUploaderPage;
    DragAndDropPage dragAndDropPage;
    ContextMenuPage contextMenuPage;
    JavaScriptAlertsPage javaScriptAlertsPage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
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
