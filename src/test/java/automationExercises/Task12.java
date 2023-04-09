package automationExercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

public class Task12 {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        //6. Click 'Continue Shopping' button
        //7. Hover over second product and click 'Add to cart'
        //8. Click 'View Cart' button
        //9. Verify both products are added to Cart
        //10. Verify their prices, quantity and total price

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
        //4. Click 'Products' button
        //5. Hover over first product and click 'Add to cart'
        //6. Click 'Continue Shopping' button
        //7. Hover over second product and click 'Add to cart'
        //8. Click 'View Cart' button
        //9. Verify both products are added to Cart
        //10. Verify their prices, quantity and total price
    @Test
    public void test1() throws InterruptedException, AWTException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        actions.sendKeys(Keys.PAGE_UP).perform();

        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        Thread.sleep(1000);
        WebElement product1=driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        WebElement product2=driver.findElement(By.xpath("//a[@href='/product_details/2']"));
        Assert.assertTrue(product1.isDisplayed() && product2.isDisplayed());

        WebElement price1=driver.findElement(By.xpath("(//td[@class='cart_price'])[1]"));
        WebElement price2=driver.findElement(By.xpath("(//td[@class='cart_price'])[2]"));
        Assert.assertTrue(price1.isDisplayed() && price2.isDisplayed());

        WebElement quantity1=driver.findElement(By.xpath("(//td[@class='cart_quantity'])[1]"));
        WebElement quantity2=driver.findElement(By.xpath("(//td[@class='cart_quantity'])[2]"));
        Assert.assertTrue(quantity1.isDisplayed() && quantity2.isDisplayed());

        WebElement total1=driver.findElement(By.xpath("(//td[@class='cart_total'])[1]"));
        WebElement total2=driver.findElement(By.xpath("(//td[@class='cart_total'])[2]"));
        Assert.assertTrue(total1.isDisplayed() && total2.isDisplayed());



        //Robot robot = new Robot();
        //robot.mouseWheel(8);



    }
}
