package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVSActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize();
        WebElement features = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions act = new Actions(driver);
        //act.moveToElement(features).perform();
        Action action = act.moveToElement(features).build();
        action.perform();

        Thread.sleep(3000);
        driver.quit();

    }
}
