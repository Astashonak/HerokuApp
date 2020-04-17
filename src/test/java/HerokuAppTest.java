import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HerokuAppTest {

    @Test
    public void addRemoveElements(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//div[@id='elements']/button[@class='added-manually']")).click();
        int numOfElements = driver.findElements(By.xpath("//div[@id='elements']/button[@class='added-manually']")).size();
        Assert.assertEquals(numOfElements, 1, "элемент не удалился");
        driver.quit();
    }

    @Test
    public void checkboxes(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement element1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        Assert.assertFalse(element1.isSelected(), "checkbox1 выбран");
        element1.click();
        Assert.assertTrue(element1.isSelected(), "checkbox1 не выбран");
        WebElement element2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        Assert.assertTrue(element2.isSelected(), "checkbox2 не выбран");
        element2.click();
        Assert.assertFalse(element2.isSelected(), "checkbox2 выбран");
        driver.quit();
    }

    @Test
    public void dropdown(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        assertFalse("Dropdown поддерживает множественный выбор",select.isMultiple());
        assertEquals("В Dropdown не три варианта выбора",3, select.getOptions().size());
        select.selectByVisibleText("Option 1");
        String text1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Option 1", "Option 1 не выбран");
        select.selectByVisibleText("Option 2");
        String text2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "Option 2", "Option 2 не выбран");
        driver.quit();
    }

}
