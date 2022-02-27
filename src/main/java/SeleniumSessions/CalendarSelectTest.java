package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CalendarSelectTest {

    public static void main(String[] args) throws InterruptedException {

       // System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker"); // enter URL

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();


        String pDate = "30-May-2023";
        String dateArr[] = pDate.split("-");
        String pDay = dateArr[0];
        String pMonth = dateArr[1];
        String pYear = dateArr[2];

        while(true){
            WebElement monthWeb = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            WebElement yearWeb =  driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            String year = yearWeb.getText();
            String month = monthWeb.getText();
            System.out.println(year);
            if(year.equals(pYear) && month.equals(pMonth)){
                break;
            }else{
                WebElement rightArrow = driver.findElement(By.xpath("//a[@title='Next']"));
                rightArrow.click();
            }
        }

        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for(WebElement day:days){
            if(day.getText().equals(pDay)){
                day.click();
            }
        }

        Thread.sleep(3000);

        driver.close();


    }
}
