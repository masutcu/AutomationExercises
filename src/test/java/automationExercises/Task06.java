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

public class Task06 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'




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
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    // 5. Verify 'GET IN TOUCH' is visible
    @Test
    public void test1(){
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
        WebElement text1=driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        Assert.assertTrue(text1.isDisplayed());
    }
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("mehmet");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("password1@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("sgk");
        driver.findElement(By.xpath("//textarea[@data-qa='message']")).sendKeys("EYT haktır.");


    }
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully
    @Test
    public void test3(){
        WebElement upload=driver.findElement(By.xpath("//input[@name='upload_file']"));
        upload.submit();

        driver.switchTo().alert().accept();

        WebElement text=driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"));
        Assert.assertTrue(text.isDisplayed());

        driver.findElement(By.xpath("//span[text()=' Home']")).click();

        WebElement homepage=driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(homepage.isDisplayed());

    }
}
