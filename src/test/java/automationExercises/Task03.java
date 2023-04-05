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

import java.time.Duration;

public class Task03 {
    /*

1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible

     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationexercise.com");

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test //Verify that home page is visible successfully
    public void test1() throws InterruptedException {
        //Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
    }
    @Test //Click on 'Signup / Login' button, Verify 'Login to your account' is visible
    public void test2() throws InterruptedException {
        WebElement singUpButton=driver.findElement(By.xpath("//a[@href='/login']"));
        singUpButton.click();
        Thread.sleep(1000);
        WebElement loginAcc=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginAcc.isDisplayed());

    }
    @Test //Enter correct email address and password, Click 'login' button
    public void test3(){
        driver.findElement(By.cssSelector("*[data-qa='login-email']")).sendKeys("passwor@gmailss.com");
        driver.findElement(By.cssSelector("*[data-qa='login-password']")).sendKeys("passwor");
        driver.findElement(By.cssSelector("*[data-qa='login-button']")).click();

    }
@Test
    public void test4(){
        WebElement textIncPss=driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(textIncPss.isDisplayed());
}
}
