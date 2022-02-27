package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
        //1. xpath:
        // driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Tom");
        // driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Peter");
        // driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("cc@gmail.com");
        // Thread.sleep(2000);
        //driver.quit();

        //2. id:
        //driver.findElement(By.id("firstname")).sendKeys("Jerry");
        //driver.findElement(By.id("lastname")).sendKeys("Bill");
        //Thread.sleep(2000);
        //3.name
        driver.findElement(By.name("firstname")).sendKeys("Tom");
        driver.findElement(By.name("lastname")).sendKeys("Peter");
        driver.findElement(By.name("Email")).sendKeys("cc@gmail.com");
       // driver.findElement(By.name("password")).sendKeys("nhdkjk%3040");
        Thread.sleep(2000);

        //4 linkText
        //  driver.findElement(By.linkText("Sign in")).click();
        // Thread.sleep(2000);
       //driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT")).click();
       //Thread.sleep(2000);
        //driver.close();

        //5 partialLinkText: not useful
        //driver.findElement(By.partialLinkText("Privacy Notice")).click();
        //6 CSS Selector
        driver.findElement(By.cssSelector("#password")).sendKeys("nhdkjk%3040");
        driver.findElement(By.className("btn")).click();

    }
}
