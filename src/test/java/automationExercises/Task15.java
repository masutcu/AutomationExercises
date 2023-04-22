package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
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

import static org.junit.Assert.assertTrue;

public class Task15 {



    static WebDriver driver;
    //1. Launch browser
    @BeforeClass
        public static void launchBrw(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.navigate().to("http://automationexercise.com");
        }
    @AfterClass
    public static void closeBrw() throws InterruptedException {
        Thread.sleep(1000);
        //driver.close();
    }

    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    @Test
    public void homePageAndLogin() throws InterruptedException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
    //4. Click 'Signup / Login' button
    //5. Fill all details in Signup and create account
    //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("mali");


        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("pass666@gmail.com");

        //Click 'Signup' button
        WebElement signUpEnter = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpEnter.click();

        //RadioButton
        driver.findElement(By.id("id_gender1")).click();
        //password
        driver.findElement(By.id("password")).sendKeys("7777777");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.TAB).sendKeys("13").sendKeys(Keys.TAB).sendKeys("August").
                sendKeys(Keys.TAB).sendKeys("1979").perform();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        actions.sendKeys(Keys.TAB).
                sendKeys("mehmet ali").sendKeys(Keys.TAB).sendKeys("Bey").sendKeys(Keys.TAB).
                sendKeys("Apple Company").sendKeys(Keys.TAB).sendKeys("N Y C").sendKeys(Keys.TAB).
                sendKeys("New York City").sendKeys(Keys.TAB).sendKeys("United States").sendKeys(Keys.TAB).
                sendKeys("NYC").sendKeys(Keys.TAB).sendKeys("New York").sendKeys(Keys.TAB).sendKeys("125252").
                sendKeys(Keys.TAB).sendKeys("5531010120").perform();
        //create account button
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).submit();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //açılan reklamı atlamak için
        driver.navigate().back();
        driver.navigate().forward();

    }
    //7. Verify ' Logged in as username' at top
    //8. Add products to cart
    //9. Click 'Cart' button
    //10. Verify that cart page is displayed
    //11. Click Proceed To Checkout
    //12. Verify Address Details and Review Your Order
    //13. Enter description in comment text area and click 'Place Order'
    //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    //15. Click 'Pay and Confirm Order' button
    //16. Verify success message 'Your order has been placed successfully!'
    //17. Click 'Delete Account' button
    //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    @Test
    public void addProduct() throws InterruptedException {
        WebElement loggedAs=driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedAs.isDisplayed());
        Thread.sleep(1000);
        Actions actions=new Actions(driver);
        WebElement hedef=driver.findElement(By.xpath("(//span[@class='pull-right'])[8]"));
        actions.scrollToElement(hedef).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='1'])")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='3'])")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        WebElement shopingPage=driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
        Assert.assertTrue(shopingPage.isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

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
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Mehmet Ali");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1212 4545 3232 6565");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("08");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2025");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //16. Verify success message 'Your order has been placed successfully!'
        //String text=driver.findElement(By.xpath("(//div[@class='form-row'])[4]")).getText();

       // driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

      // String actualtext=driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
      // String expectedText="ACCOUNT DELETED!";
      // Assert.assertEquals(actualtext,expectedText);

      // driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }

}
