package SeleniumSessions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver(); //launch chrome
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(5000);
        Alert alert =driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();


        /*
        WebElement element = driver.findElement(By.id("promtButton"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert.sendKeys("uest User");
        promptAlert.accept();
        */

        WebElement element = driver.findElement(By.id("promtButton"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        element.click();
        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);
        promptAlert.sendKeys("user name");
        promptAlert.accept();

        driver.findElement(By.id("confirmButton")).click();
        Alert confirmAlert = driver.switchTo().alert();
        String confirmText = confirmAlert.getText();
        System.out.println(confirmText);
        Thread.sleep(2000);
        confirmAlert.accept();
        driver.close();

    }
}
