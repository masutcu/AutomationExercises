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
    @Test
    public void test1() throws InterruptedException, AWTException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        WebElement box=driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
       // Actions actions=new Actions(driver);

        Thread.sleep(2000);


        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();



    }
}
