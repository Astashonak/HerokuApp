package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {

    private static final String URL = "http://the-internet.herokuapp.com/javascript_alerts";
    private static final By JS_ALERT = By.xpath("//*/button[@onclick='jsAlert()']");
    private static final By RESULT_TEXT_LOCATOR = By.id("result");
    private static final By JS_CONFIRM = By.xpath("//*/button[@onclick='jsConfirm()']");
    private static final By JS_PROMPT = By.xpath("//*/button[@onclick='jsPrompt()']");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() { driver.get(URL); }

    public void operationsWithJSAlert(){
        driver.findElement(JS_ALERT).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void confirmResult(String realResultMessage){
        String resultMessage = driver.findElement(RESULT_TEXT_LOCATOR).getText();
        Assert.assertEquals(resultMessage, realResultMessage, "Текст результата не совпадает (JSAlert)");
    }

    public void operationsWithJSConfirmOKCase(){
        driver.findElement(JS_CONFIRM).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void operationsWithJSConfirmCancelCase(){
        driver.findElement(JS_CONFIRM).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void operationsWithJSPromptCancelCase(){
        driver.findElement(JS_PROMPT).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void operationsWithJSPromptOKCase(String sendMessage){
        driver.findElement(JS_PROMPT).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(sendMessage);
        alert.accept();
    }
}
