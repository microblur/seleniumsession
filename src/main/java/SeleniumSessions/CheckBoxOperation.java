package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxOperation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        //validate isSelected and click
        WebElement checkBoxSelected = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isSelected =  checkBoxSelected.isSelected();
        System.out.println(isSelected);

        if(isSelected==false){
            checkBoxSelected.click();
        }

         */

        List<WebElement> checkBoxes =  driver.findElements(By.xpath("//label[contains(@for,'hobbies')]"));
        for (WebElement chBox:checkBoxes) {
            String text =  chBox.getText();
            System.out.println(text);
            if(text.equals("Sports")){
                chBox.click();
            }
        }

        /*

        //validate isDisplayed and click
        WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
        boolean isDisplayed =  checkBoxDisplayed.isDisplayed();
        System.out.println(isDisplayed);
        if(isDisplayed){
            checkBoxDisplayed.click();
        }


         */
        //validate isEnabled and click

        WebElement checkBoxEnabled = driver.findElement(By.xpath("//label[text()='Music']"));
        boolean isEnabled = checkBoxEnabled.isEnabled();
        System.out.println(isEnabled);
        if(isEnabled){
            checkBoxEnabled.click();
        }
         Thread.sleep(5000);
        driver.close();
    }
}
