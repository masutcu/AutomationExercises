package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Task11 {

         //1. Launch browser
         //2. Navigate to url 'http://automationexercise.com'



         static WebDriver driver;
    @BeforeClass
    public static void launchBrw(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://automationexercise.com");
    }
    @AfterClass
    public static void closeBrw() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
    //3. Verify that home page is visible successfully
    //4. Click 'Cart' button
    //5. Scroll down to footer
    //6. Verify text 'SUBSCRIPTION'
    @Test
    public void test01(){
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("(//a[@href=\"/view_cart\"])[1]")).click();
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement subs=driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subs.isDisplayed());
    }
    //7. Enter email address in input and click arrow button
    //8. Verify success message 'You have been successfully subscribed!' is visible
    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("password1@gmail.com",Keys.ENTER);
        WebElement text01=driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
    Assert.assertTrue(text01.isDisplayed());
    }

}
