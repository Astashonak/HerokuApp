import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}
