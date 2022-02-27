package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class XPathDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/eric/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/text-box");

        //Using contains() to locate full name and enter data
        driver.findElement(By.xpath("//input[contains(@id, 'userN')]")).sendKeys("User Name");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@id, 'userN')]")).clear();
        //using placeholder
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Fu' )]")).sendKeys("Using Placeholder");
        String text = driver.findElement(By.xpath("//label[text()='Email']")).getText();
        System.out.println(text);
         //using AND operator to locate the full name
        driver.findElement(By.xpath("//input[@placeholder='Full Name' and @type='text']")).sendKeys("AND operator");

        //using OR operator to locate the full name
        driver.findElement(By.xpath("//input[@placeholder ='Full Name' or @type='text']")).sendKeys("OR operator");
        Thread.sleep(2000);
        //using ancestor to locate form tag
       // boolean bol=driver.findElement(By.xpath("//input[@id='userName']/ancestor::form")).isDisplayed();
        boolean bol=driver.findElement(By.xpath("//label[text()='Full Name']/ancestor::form")).isDisplayed();
        System.out.println(bol);
        //using child to locate label

        //using child to locate full name textbox from form

        String label =  driver.findElement(By.xpath("//form[@id='userForm']/child::div[1]//label")).getText();
        System.out.println(label);

        //using descent axis to locate Yes radio
        driver.get("https://www.demoqa.com/radio-button");

        driver.findElement(By.xpath("//div[@class= 'custom-control custom-radio custom-control-inline']/descendant::input/following-sibling::label")).click();
        //using parent axis to locate yes radio
        driver.findElement(By.xpath("//label[text()='Impressive']")).click();
        //boolean radio =  driver.findElement(By.xpath("//input[@id='yesRadio']/parent::div")).isSelected();
        boolean bo = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        System.out.println("The yes radio is selected: "+bo);

        //using following axis to locate current address
        driver.navigate().back();
       // driver.findElement(By.xpath("//div[@id=\"userName\"]/following::textarea")).sendKeys("Text Area locate following");
        driver.findElement(By.xpath("//input[@id=\"userName\"]/following::textarea")).sendKeys("Text Area locate following");

        String preceding = driver.findElement(By.xpath("//input[@id='userName']/preceding::label")).getText();
        System.out.println("The preceding is " + preceding);
        Thread.sleep(2000);
        driver.close();
    }
}
