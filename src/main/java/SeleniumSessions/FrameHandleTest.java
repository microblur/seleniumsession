package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameHandleTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/guru99home/");
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window handler:"+mainWindow);

        driver.switchTo().frame("a077aa5e");
        System.out.println("****We are switch to the iframe****");
        driver.findElement(By.xpath("html/body/a/img")).click();
        System.out.println("****We are done****"+driver.getTitle());

        System.out.println("Current window handle:"+driver.getWindowHandles());

        driver.switchTo().window(mainWindow);
        //switch back to main window
        System.out.println("Switch to main window");
        driver.switchTo().defaultContent();

        WebElement emailbox=driver.findElement(By.xpath("//input[@id='philadelphia-field-email']"));
        emailbox.sendKeys("test02@gmail.com");
        driver.findElement(By.xpath("//button[@id='philadelphia-field-submit']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.quit();


    }
}
