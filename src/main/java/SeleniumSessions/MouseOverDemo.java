package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MouseOverDemo {
    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver","/Users/eric/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://demoqa.com/menu");
        Actions action = new Actions(driver);
        WebElement webElement = driver.findElement(By.linkText("Main Item 2"));
        System.out.println(webElement.getText());

        action.moveToElement(webElement).click().perform();

        WebElement subMenu = driver.findElement(By.partialLinkText("SUB SUB LIST"));
        action.moveToElement(subMenu).click().perform();
    }
}
