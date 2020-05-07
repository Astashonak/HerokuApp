package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DragAndDropPage extends BasePage {
    private static final String URL = "http://the-internet.herokuapp.com/drag_and_drop";
    private static final By FROM_LOCATOR = By.id("column-a");
    private static final By TO_LOCATOR = By.id("column-b");
    private static final By COLUMN_A_HEADER = By.xpath("//*[@id='column-a']/header");
    private static final By COLUMN_B_HEADER = By.xpath("//*[@id='column-b']/header");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void determineInitialPositionOfElementA(String initialColumnName) {
        String actualColumnNameBefore = driver.findElement(COLUMN_A_HEADER).getText();
        Assert.assertEquals(actualColumnNameBefore, initialColumnName,
                "Изначально находится не в нужной колонке");
    }

    public void dragAndDropAction() {
        WebElement FromA = driver.findElement(FROM_LOCATOR);
        WebElement ToB = driver.findElement(TO_LOCATOR);
//        actions.clickAndHold(FromA).moveToElement(ToB).release().build().perform();
        actions.dragAndDrop(FromA, ToB).build().perform();
    }

    public void determineFinalPositionOfElementA(String finalColumnName) {
        String actualColumnNameAfter = driver.findElement(COLUMN_B_HEADER).getText();
            Assert.assertEquals(actualColumnNameAfter, finalColumnName,
                    "Элемент не попал в нужную колонку");
        }
    }

