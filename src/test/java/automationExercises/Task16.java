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

import java.awt.*;
import java.time.Duration;

public class Task16 {
        static WebDriver driver;
    //1. Launch browser
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

    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    @Test
    public void homePage() throws InterruptedException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Signup / Login' button
        //5. Fill email, password and click 'Login' button
        //6. Verify 'Logged in as username' at top
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pass666@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("7777777");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        WebElement text01=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(text01.isDisplayed());
        //7. Add products to cart
        //8. Click 'Cart' button
        //9. Verify that cart page is displayed
        //10. Click Proceed To Checkout
        //11. Verify Address Details and Review Your Order
        //12. Enter description in comment text area and click 'Place Order'
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //14. Click 'Pay and Confirm Order' button
        //15. Verify success message 'Your order has been placed successfully!'
        //16. Click 'Delete Account' button
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        driver.findElement(By.xpath("//a[text()=' Cart']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());

        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

        //12. Verify Address Details and Review Your Order

        WebElement verify1=driver.findElement(By.xpath("(//li[text()='New York City'])[1]"));
        String actual=verify1.getText();
        String expected="New York City";
        Assert.assertEquals(expected,actual);

        WebElement verify2=driver.findElement(By.xpath("(//li[text()='5531010120'])[2]"));
        String actual2=verify2.getText();
        String expected2="5531010120";
        Assert.assertEquals(expected2,actual2);

        WebElement hedef1=driver.findElement(By.xpath("(//h2)[3]"));
        actions.scrollToElement(hedef1).perform();

        //sending comment on text area
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Kırmadan dökmeden getirin");
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();
        Thread.sleep(1000);
        //reklemı atlamak için
        driver.navigate().back();
        driver.navigate().forward();
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Mehmet Ali");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1212 4545 3232 6565");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("08");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2025");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //16. Verify success message 'Your order has been placed successfully!' BAŞARISIZ

        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

        String actualtext=driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
        String expectedText="ACCOUNT DELETED!";
        Assert.assertEquals(actualtext,expectedText);

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    }



}
