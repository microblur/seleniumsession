package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsConcept {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://www.facebook.com");
        List<WebElement> list =  driver.findElements(By.tagName("a"));

        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            String linkText = list.get(i).getText();
            System.out.println(linkText);
        }


    }
}
