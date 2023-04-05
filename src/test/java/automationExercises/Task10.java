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

public class Task10 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible
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
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test1() throws InterruptedException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement text=driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(text.isDisplayed());
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("password1@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        WebElement alartmessage=driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        Assert.assertTrue(alartmessage.isDisplayed());
    }
}
