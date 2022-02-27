package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ChildWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();
        //WebElement text=driver.findElement(By.id("sampleHeading"));
        String mainWindowHandle =  driver.getWindowHandle();
        System.out.println("The main window handle is "+mainWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);

        Iterator<String > iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                //WebElement text = driver.findElement(By.id("sampleHeading"));
                //System.out.println(text.getText());
                System.out.println(childWindow+ "Child window closed");

                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
        mainWindowHandle =  driver.getWindowHandle();
        System.out.println("The main window handle is "+mainWindowHandle);
        driver.quit();
    }
}
