package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://demoqa.com/droppable/");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(drag,drop).perform();
        String toText = drop.getText();
        if(toText.equalsIgnoreCase("Dropped!")){
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
        //driver.close();

        driver.navigate().refresh();

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        Actions builder = new Actions(driver);

        int xOffSet1 = from.getLocation().getX();
        int yOffSet1 = from.getLocation().getY();

        int xOffSet =  to.getLocation().getX();
        int yOffSet = to.getLocation().getY();

        xOffSet = xOffSet-xOffSet1+10;
        yOffSet = yOffSet-yOffSet1+20;

        builder.dragAndDropBy(from,xOffSet,yOffSet).perform();

        String dragText = to.getText();
        if(toText.equalsIgnoreCase("Dropped!")){
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        driver.close();

    }
}

