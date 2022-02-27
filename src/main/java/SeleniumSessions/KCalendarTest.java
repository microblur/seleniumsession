package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class KCalendarTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //Test for Kendo Calendar
        driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");

        WebElement kDatePicker = driver.findElement(By.cssSelector(".k-icon.k-i-calendar"));
        kDatePicker.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datetimepicker_dateview")));
        System.out.println("Calender Found");


        WebDriverWait driverWait = new WebDriverWait(driver,10);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-content")));


        WebElement table = driver.findElement(By.className("k-content"));
        System.out.println("Kendo Calendar");
        List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
        System.out.println(tableRows.size());
        for(WebElement row:tableRows){
            List<WebElement> cells = row.findElements(By.xpath("td"));
            for(WebElement cell:cells){
                if(cell.getText().equals("20")){
                    driver.findElement(By.linkText("20")).click();
                }
            }
        }

        /*
        WebElement eleTable = driver.findElement(By.className("k-content"));
        System.out.println("Kendo Calender Found");

        WebElement selectedElem =  driver.findElement(By.className("k-nav-fast"));
        String selectedMonthYear = selectedElem.getAttribute("innerHTML");

        System.out.println(selectedMonthYear);

        String targetYear = "2024";
        String targetMonth ="February";
        String targetDate = "20";
        String targetMonthYear = targetMonth+" "+targetYear;

        while (!selectedMonthYear.equals(targetMonthYear)) {
            driver.findElement(By.className("k-nav-next")).click();
            Thread.sleep(2);
            selectedElem = driver.findElement(By.className("k-nav-fast"));
            selectedMonthYear = selectedElem.getAttribute("innerHTML");
        }
        Thread.sleep(5);

        //System.out.println(eleTable.getText());

        List<WebElement> list = eleTable.findElements(By.xpath("//tr"));
        System.out.println(list.size());
        for(WebElement row: list){
           List<WebElement> cells = row.findElements(By.xpath("td"));
           for (WebElement cell : cells){
               if (cell.getText().equals(targetDate)) {
                   System.out.println(cell.getText());
                   driver.findElement(By.linkText(targetDate)).click();
                   break;
               }

           }
        }

         */

    }

}
