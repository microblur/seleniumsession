package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleStaticTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        List<WebElement> tableHead= driver.findElements(By.xpath("//table[@id='customers']//th"));
        for (WebElement th:tableHead) {
            System.out.print(th.getText());
            System.out.print("   ");
        }
        System.out.println();
        int cols = tableHead.size();
        List<WebElement> td = driver.findElements(By.xpath("//table[@id='customers']//td"));
        int row = driver.findElements(By.xpath("//table[@id='customers']//tr")).size()-1;
        System.out.println("row is "+ row);

        for(int i=1;i<=td.size();i++) {
                System.out.print(td.get(i-1).getText());
                System.out.print("   ");
                if(i%cols==0)
                    System.out.println();
            }


    }
}
