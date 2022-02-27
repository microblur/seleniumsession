package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleLinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.deadlinkcity.com");


        //driver.findElement(By.xpath("//span[contains(text(),'Change')]")).click();
        //driver.findElement(By.linkText("Today's Deals")).click();
        //driver.findElement(By.partialLinkText(("Deals"))).click();

        List<WebElement> links= driver.findElements(By.tagName("a"));
        for(WebElement ele:links){

            String url = ele.getAttribute("href");

            if(url==null|| url.isEmpty()){
                System.out.println("URL is empty");
                continue;
            }
            URL link = new URL(url);
            try{
                HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
                httpconn.connect();
                if(httpconn.getResponseCode()>=400){
                    System.out.println(httpconn.getResponseCode()+url+" is"+" Broken link");
                }else {
                    System.out.println(httpconn.getResponseCode()+url+" is "+" valid link");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
