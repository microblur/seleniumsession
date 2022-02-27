package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class KeyboardEventsUsingActions {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");

        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");

        Actions actions = new Actions(driver);
        /*
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("a");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();
        */
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();

        /*
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("c");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();
        */

        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).build().perform();
        actions.sendKeys(Keys.TAB).build().perform();


        /*
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("v");
        actions.keyUp(Keys.COMMAND);
        actions.build().perform();
        */
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        System.out.println(permanentAddress.getAttribute("value"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));


        driver.close();

    }
}
