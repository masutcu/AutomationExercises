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
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class Task14 {
    //1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Add products to cart
//5. Click 'Cart' button
//6. Verify that cart page is displayed
//7. Click Proceed To Checkout
//8. Click 'Register / Login' button
//9. Fill all details in Signup and create account
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//11. Verify ' Logged in as username' at top
//12.Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
//19. Click 'Delete Account' button
//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    static WebDriver driver;

    @BeforeClass
    public static void launchBrw() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
    //4. Add products to cart
    //5. Click 'Cart' button
    //6. Verify that cart page is displayed
    //7. Click Proceed To Checkout
    @Test
    public void test1() throws InterruptedException, AWTException {
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
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

        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

    }
    //8. Click 'Register / Login' button
    //9. Fill all details in Signup and create account
    //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    //11. Verify ' Logged in as username' at top
    @Test
    public void test2() throws InterruptedException, AWTException {

        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
        WebElement singUpButton=driver.findElement(By.xpath("//a[@href='/login']"));
        singUpButton.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Mehmet");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("password15@gmail.com");


        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password2",Keys.ENTER);

        WebElement date = driver.findElement(By.xpath("//select[@id='days']"));
        Select date1=new Select(date);
        date1.selectByValue("11");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select month1=new Select(month);
        month1.selectByValue("3");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select year1=new Select(year);
        year1.selectByVisibleText("1979");
        Thread.sleep(1000);

        //Select checkbox 'Sign up for our newsletter!'
        WebElement check =driver.findElement(By.xpath("//label[@for='newsletter']"));
        if(!check.isSelected())
            check.click();
        Thread.sleep(1000);

        //   Select checkbox 'Receive special offers from our partners!'
        WebElement check1 =driver.findElement(By.xpath("//label[@for='optin']"));
        if(!check1.isSelected())
            check1.click();

        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        WebElement firstName =driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("david");

        WebElement lastName =driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("gold");

        WebElement company =driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("milkyCompany");

        WebElement address1 =driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("Manhettan");

        WebElement address2 =driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys("NewYorkCity");

        WebElement ulke=driver.findElement(By.xpath("//select[@id='country']"));
        Select slc=new Select(ulke);
        slc.selectByIndex(1);

        WebElement country =driver.findElement(By.xpath("//select[@id='country']"));
        Select tr=new Select(country);
        country.sendKeys("USA");

        //State, City, Zipcode, Mobile Number
        WebElement state=driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("NYC");

        WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("NewYork");

        WebElement zip=driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.sendKeys("061525");

        Robot robot=new Robot();
        robot.mouseWheel(5);

        WebElement tel=driver.findElement(By.xpath("//input[@id='mobile_number']"));
        tel.sendKeys("5525252321");
        Thread.sleep(1000);


//       Click 'Create Account button'
        WebElement createAButton=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAButton.click();

//    Verify that 'ACCOUNT CREATED!' is visible

        WebElement accountIs=driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        assertTrue(accountIs.isDisplayed());
        //continue button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        //Task de yok açılan pencereyi kapatıyoruz
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();

//       Verify that 'Logged in as username' is visible
        WebElement loggedAs=driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedAs.isDisplayed());

    }
    //12.Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        WebElement verify1=driver.findElement(By.xpath("(//li[text()='Manhettan'])[1]"));
        String actual=verify1.getText();
        String expected="Manhettan";
        Assert.assertEquals(expected,actual);

        WebElement verify2=driver.findElement(By.xpath("(//li[text()='5525252321'])[2]"));
        String actual2=verify2.getText();
        String expected2="5525252321";
        Assert.assertEquals(expected2,actual2);

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
        Thread.sleep(2000);
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button


        String lanetOlasiText=driver.findElement(By.xpath("//*[text()[normalize-space()='Your order has been placed successfully!']]")).getText();
        System.out.println("text: "+lanetOlasiText);
        Assert.assertTrue(lanetOlasiText.contains("Your order has been placed successfully!"));
        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();



    }

}