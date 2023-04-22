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

public class Task20 {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Click on 'Products' button
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        //5. Enter product name in search input and click search button
        //6. Verify 'SEARCHED PRODUCTS' is visible
        //7. Verify all the products related to search are visible
        //8. Add those products to cart
        //9. Click 'Cart' button and verify that products are visible in cart
        //10. Click 'Signup / Login' button and submit login details
        //11. Again, go to Cart page
        //12. Verify that those products are visible in cart after login as well

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
    public void test20() throws InterruptedException {
        WebElement productButton = driver.findElement(By.xpath("//a[text()=' Products']"));
        productButton.click();
        //reklamı atlamak için
        driver.navigate().back();
        driver.navigate().forward();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());

        driver.findElement(By.id("search_product")).sendKeys("Linen");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());

        //7. Verify all the products related to search are visible

       List<WebElement> liste= driver.findElements(By.xpath("//p[.]"));
       for(WebElement w:liste){
           if(w.getText().contains("Linen")){
               System.out.println(w.getText());
           }
       }

        //8. Add those products to cart
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement urun1=driver.findElement(By.xpath("(//a[@data-product-id='40'])"));
        actions.moveToElement(urun1);
        Thread.sleep(1000);
        urun1.click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();


        WebElement urun2=driver.findElement(By.xpath("(//a[@data-product-id='41'])"));
        actions.moveToElement(urun2);
        Thread.sleep(1000);
        urun2.click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //9. Click 'Cart' button and verify that products are visible in cart

        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        WebElement product1=driver.findElement(By.xpath("//a[text()='Rust Red Linen Saree']"));
        WebElement product2=driver.findElement(By.xpath("//a[text()='Beautiful Peacock Blue Cotton Linen Saree']"));
        Assert.assertTrue(product1.isDisplayed() && product2.isDisplayed());

        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).
                sendKeys("pass666@gmail.com");
        actions.sendKeys(Keys.TAB).sendKeys("7777777").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        //11. Again, go to Cart page
        //12. Verify that those products are visible in cart after login as well

        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        WebElement product3=driver.findElement(By.xpath("//a[text()='Rust Red Linen Saree']"));
        WebElement product4=driver.findElement(By.xpath("//a[text()='Beautiful Peacock Blue Cotton Linen Saree']"));
        Assert.assertTrue(product3.isDisplayed() && product4.isDisplayed());


    }
}
