package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleSlider {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/slider/#rangemin/");

        WebElement iframeXpath = driver.findElement(By.xpath("//div[@id='content']/iframe"));
        driver.switchTo().frame(iframeXpath);

        WebElement slider= driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

        //WebElement slider = driver.findElement(By.xpath("//div[@id='slider-range-min']/span"));
        System.out.println("The location of slider is: "+slider.getLocation());
        int x = slider.getRect().getX();
        int y = slider.getRect().getY();
        Actions act = new Actions(driver);

        act.dragAndDropBy(slider,x+50,0).perform();
        System.out.println("The new location is: "+ slider.getRect().getX()+" "+ slider.getRect().getY());


        Thread.sleep(5000);
        driver.close();


    }

}
