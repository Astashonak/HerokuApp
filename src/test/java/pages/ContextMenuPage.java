package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContextMenuPage extends BasePage{

    private static final String URL = "http://the-internet.herokuapp.com/context_menu";
    private static final By ELEMENT_LOCATOR = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void rightClickAction(){
        WebElement rightClick = driver.findElement(ELEMENT_LOCATOR);
        actions.contextClick(rightClick).build().perform();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void verifyAlertText(String realAlertMessage){
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, realAlertMessage, "Текст алерта не совпадает");
        alert.accept();
    }
}
