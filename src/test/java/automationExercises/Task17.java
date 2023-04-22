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
import java.util.List;

public class Task17 {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Add products to cart
        //5. Click 'Cart' button
        //6. Verify that cart page is displayed
        //7. Click 'X' button corresponding to particular product
        //8. Verify that product is removed from the cart
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
    public void test17() throws InterruptedException {
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

        List<WebElement> list1=driver.findElements(By.xpath("//a[@class='cart_quantity_delete']"));
        System.out.println("list1.size() = " + list1.size());

        driver.findElement(By.xpath("(//a[@class='cart_quantity_delete'])[2]")).click();
        Thread.sleep(1000);
        List<WebElement> list2=driver.findElements(By.xpath("//a[@class='cart_quantity_delete']"));
        System.out.println("list2.size() = " + list2.size());

        Assert.assertTrue(list1.size()-1==list2.size());






    }
}
