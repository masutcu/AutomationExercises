package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
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
    public void t1_homePage(){
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
    }
    @Test
    public void t2_login() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1000);
        WebElement text1=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(text1.isDisplayed());
    }
    @Test
    public void t3_emailPsw() throws InterruptedException {
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("password1@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("password1");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        WebElement text2=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(text2.isDisplayed());
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        WebElement text1=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(text1.isDisplayed());


    }


}
