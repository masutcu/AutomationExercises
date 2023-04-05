package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task05 {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */
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
    @Test
    public void testhp(){
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
    }
    @Test
    public void testTask() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1000);
        WebElement text1=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(text1.isDisplayed());
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Mehmet");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("password1@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        WebElement visible=driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        Assert.assertTrue(visible.isDisplayed());
    }
}
