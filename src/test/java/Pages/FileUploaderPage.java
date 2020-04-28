package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FileUploaderPage extends BasePage {

    private static final String URL = "http://the-internet.herokuapp.com/upload";
    private static final By CHOOSE_FILE = By.id("file-upload");
    private static final By UPLOAD_BUTTON = By.id("file-submit");
    private static final By FILE_UPLOADED_MESSAGE =  By.xpath("//*/h3[contains(text(), 'File Uploaded!')]");
    private static final String FILE_PATH = "C:/Users/Lena/IdeaProjects/HerokuApp/src/test/resources/test for uploading a file.docx";

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void validateFileUploader() {
        driver.findElement(CHOOSE_FILE).sendKeys(FILE_PATH);
        driver.findElement(UPLOAD_BUTTON).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(FILE_UPLOADED_MESSAGE));
        Assert.assertTrue(driver.findElement(FILE_UPLOADED_MESSAGE).isDisplayed(), "File не загрузился");
    }
}
