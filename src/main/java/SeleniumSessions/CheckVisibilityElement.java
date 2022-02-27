package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckVisibilityElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://register.freecrm.com/register/");

        Boolean isDisplayed = driver.findElement(By.name("action")).isDisplayed();
        System.out.println(isDisplayed);
        Boolean isEnabled = driver.findElement(By.name("action")).isEnabled();
        System.out.println(isEnabled);
        Boolean isSelected = driver.findElement(By.name("terms")).isSelected();
        System.out.println(isSelected);
        //lets make submit button enabled:

        driver.findElement(By.name("terms")).click(); //check I Agree checkbox
        isSelected = driver.findElement(By.name("terms")).isSelected();
        System.out.println(isSelected);
        driver.findElement(By.name("terms")).click();
        isSelected = driver.findElement(By.name("terms")).isSelected();
        System.out.println(isSelected);
        Thread.sleep(2000);
        driver.close();

    }
}
