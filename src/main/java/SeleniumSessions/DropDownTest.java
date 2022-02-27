package SeleniumSessions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);


        /*
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        Select dropCountry = new Select(driver.findElement(By.name("country")));
        dropCountry.selectByVisibleText("ANTARCTICA");
        */

        driver.get("https://demoqa.com/select-menu");

       WebElement selectOne = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        //WebElement selectOne=driver.findElement(By.xpath("//*[@id='selectOne']/div/div/div/div"));
        //selectOne.click();
        selectOne.sendKeys(Keys.ARROW_DOWN);
        selectOne.sendKeys(Keys.RETURN);
        System.out.println(selectOne.getAttribute("value"));
        // driver.findElement(By.xpath("//*[@id='selectOne']/div/div/div/div/input"));
       // selectOne.sendKeys("Dr."+Keys.ENTER);
       // selectOne.sendKeys(Keys.ARROW_DOWN);
        //selectOne.sendKeys(Keys.ENTER);
        //selectOne.click();

        Thread.sleep(3000);


        System.out.println("selectOne Text is "+selectOne.getAttribute("value"));

        Select colors = new Select(driver.findElement(By.id("oldSelectMenu")));
        colors.selectByVisibleText("Green");
         colors.selectByVisibleText("Red");
        List<WebElement> options= colors.getOptions();
        for(WebElement e:options){
            System.out.println(e.getText());
        }
        //fruits.selectByIndex(5);
        System.out.println(colors.isMultiple());

        Select cars = new Select(driver.findElement(By.name("cars")));
        cars.selectByIndex(1);
        cars.selectByValue("audi");
        System.out.println("*****check options is selected or not******");
        List<WebElement> carsOptions= cars.getOptions();
        for(WebElement e:carsOptions){
            System.out.println(e.isSelected());
        }
        cars.deselectAll();
    }
}
