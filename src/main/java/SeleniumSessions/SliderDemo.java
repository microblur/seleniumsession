package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SliderDemo {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/slider/");
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        System.out.println(slider.getLocation());
        //WebElement slider = driver.findElement(By.cssSelector("div[class='range-slider__tooltip range-slider__tooltip--auto range-slider__tooltip--bottom']"));
        //actions.moveToElement(slider,50,0).perform();
       // slider.click();
        actions.dragAndDropBy(slider,50,0);
        slider.click();
        System.out.println(slider.getLocation());
        System.out.println("Moved slider in horizontal directions");
        Thread.sleep(5000);
       // driver.close();

    }
}
