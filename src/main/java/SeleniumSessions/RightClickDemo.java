package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RightClickDemo {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        WebElement btnElement = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(btnElement).perform();

        WebElement elementOpen = driver.findElement(By.xpath("//p[@id='rightClickMessage']"));


        System.out.println(elementOpen.getText());

        //double click

        WebElement dcButton =  driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(dcButton).perform();
        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());
        driver.close();

    }
}
