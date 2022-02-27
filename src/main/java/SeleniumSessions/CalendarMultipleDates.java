package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarMultipleDates {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");


        WebElement datePicker=driver.findElement(By.xpath("//input[@id='departon']"));
        datePicker.click();

        WebElement monthWeb = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select monthSelect = new Select(monthWeb);
        monthSelect.selectByVisibleText("Oct");

        WebElement yearWeb =  driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select yearSelect =  new Select(yearWeb);

        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement day:days) {
            if(day.getText().equals("10"))
                day.click();
        }

        WebElement inout= driver.findElement(By.xpath("//input[@id='departon']"));
        System.out.println(inout.getAttribute("value"));


    }
}
