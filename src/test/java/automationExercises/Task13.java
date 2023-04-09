package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
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

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Task13 {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click 'View Product' for any product on home page
        //5. Verify product detail is opened
        //6. Increase quantity to 4
        //7. Click 'Add to cart' button
        //8. Click 'View Cart' button
        //9. Verify that product is displayed in cart page with exact quantity
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
    public void test1() throws InterruptedException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement element=driver.findElement(By.xpath("//*[@href='/product_details/2']"));
        Thread.sleep(2000);
        //element.click();
        driver.findElement(with(By.tagName("a")).toRightOf(element)).click();
        //List<WebElement> list=driver.findElements(By.xpath("//i[@class='fa fa-plus-square']"));
        //System.out.println(list);
        //for(WebElement w:list){
        //    w.click();
        //    break;}
        driver.navigate().back();
        driver.navigate().forward();

        WebElement detailProduct=driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(detailProduct.isEnabled());

        //driver.findElement(By.id("quantity")).sendKeys("4"); //41 oluyor. bu şekilde olmuyor
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        String quantity=driver.findElement(By.xpath("//*[text()='4']")).getText();
        System.out.println(quantity);
        Assert.assertEquals("4",quantity);
    }

}
