package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class KeyBoardEvents {

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

        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("A");
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("C");


        currentAddress.sendKeys(Keys.TAB);

        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(Keys.CONTROL);
        permanentAddress.sendKeys("V");

        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));

         driver.close();
    }
}
