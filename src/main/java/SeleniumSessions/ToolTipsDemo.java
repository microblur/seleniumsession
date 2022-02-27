package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ToolTipsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/tool-tips/");
        Actions actions = new Actions(driver);

        WebElement webElement = driver.findElement(By.id("toolTipTextField"));

        actions.moveToElement(webElement).perform();

        String tooltips = webElement.getText();

        System.out.println(webElement.getAttribute("placeholder")+tooltips);

    }
}
