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

import java.util.List;

public class Task09 {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'



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
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully

    @Test
    public void test1() throws InterruptedException {
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        WebElement textAllProduct=driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(textAllProduct.isDisplayed());

    }
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        WebElement serchedItems=driver.findElement(By.xpath("//*[text()='Searched Products']"));
        Assert.assertTrue(serchedItems.isDisplayed());

        List<WebElement> sonuclar=driver.findElements(By.xpath("//a[text()='View Product']"));
        for(WebElement w:sonuclar){
            Assert.assertTrue(w.isDisplayed());

            }

    }

}
