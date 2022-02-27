package SeleniumSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BootstrapDropDown {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();

        //Create prefs map to store all preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

//Put this into prefs map to switch off browser notification
        prefs.put("profile.default_content_setting_values.notifications", 2);



//Create chrome options to set this prefs
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

       driver.get("https://www.hdfcbank.com/");

       driver.findElement(By.id("onetrust-accept-btn-handler")).click();

       driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();

       List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
       System.out.println("NUmber of options:"+ productTypes.size());

        for (WebElement ptype:productTypes) {
            if(ptype.getText().equals("Accounts")){
                ptype.click();
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
        System.out.println("Num of Options"+products.size());
        for(WebElement product:products){
            if(product.getText().equals("Salary Accounts")){
                product.click();
                break;
            }
        }

    }
}
