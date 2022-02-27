package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        TakesScreenshot ts =  driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File target = new File("./screenshots/homepage.png");
        FileUtils.copyFile(src,target);

        WebElement section = driver.findElement(By.xpath("//div[@class='category-grid home-page-category-grid']"));
        File srcSection = section.getScreenshotAs(OutputType.FILE);
        File trgSection = new File("./screenshots/featured.png");
        FileUtils.copyFile(srcSection,trgSection);

        WebElement img = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        File srcImg = img.getScreenshotAs(OutputType.FILE);
        File trgImg = new File("./screenshots/image.png");
        FileUtils.copyFile(srcImg,trgImg);


        driver.close();
    }
}
