package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RobotKeyDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/upload-download");
        WebElement webElement = driver.findElement(By.id("uploadFile"));

        // webElement.sendKeys(Keys.ENTER);

        System.out.println(webElement.getAttribute("class"));

        webElement.sendKeys("/Users/eric/Documents/selenium/pom.xml");
        WebElement p = driver.findElement(By.id("uploadedFilePath"));

        System.out.println(p.getText());

    }
}
