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

import java.time.Duration;

public class Task21 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Click on 'Products' button
    //4. Verify user is navigated to ALL PRODUCTS page successfully
    //5. Click on 'View Product' button
    //6. Verify 'Write Your Review' is visible
    //7. Enter name, email and review
    //8. Click 'Submit' button
    //9. Verify success message 'Thank you for your review.'

    static WebDriver driver;
    @BeforeClass
    public static void launchBrw(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://automationexercise.com");
    }
    @AfterClass
    public static void closeBrw() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void test21() throws InterruptedException {
        WebElement productButton = driver.findElement(By.xpath("//a[text()=' Products']"));
        productButton.click();
        //reklamı atlamak için
        driver.navigate().back();
        driver.navigate().forward();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());

        //5. Click on 'View Product' button
        //6. Verify 'Write Your Review' is visible
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        WebElement yorum=driver.findElement(By.xpath("//a[text()='Write Your Review']"));
        Assert.assertTrue( yorum.isDisplayed());

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Mehmet Ali");
        actions.sendKeys(Keys.TAB).sendKeys("pass666@gmail.com").sendKeys(Keys.TAB).
                sendKeys("Bu ürünün başka renkleri var mı?").
                sendKeys(Keys.PAGE_DOWN).perform();

        WebElement submit=driver.findElement(By.xpath("//button[@class='btn btn-default pull-right']"));
        Thread.sleep(1000);
        submit.submit();

        //9. Verify success message 'Thank you for your review.'
        //String a=driver.findElement(By.xpath("//span[@style='font-size: 20px;']")).getText();
        //System.out.println(a);
        //String b="Thank you for your review.";
        //Assert.assertTrue(a.contains(b));

        //2.yol
        WebElement message= driver.findElement(By.xpath("//span[@style='font-size: 20px;']"));
        System.out.println("message.getText() = " + message.getText());
        Assert.assertTrue(message.isDisplayed());


        

    }

}
