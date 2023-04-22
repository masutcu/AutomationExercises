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

public class Task19 {
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        // 3. Click on 'Products' button
        //4. Verify that Brands are visible on left side bar
        //5. Click on any brand name
        //6. Verify that user is navigated to brand page and brand products are displayed
        //7. On left side bar, click on any other brand link
        //8. Verify that user is navigated to that brand page and can see products

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
    public void test19() throws InterruptedException {
        WebElement productButton = driver.findElement(By.xpath("//a[text()=' Products']"));
        productButton.click();

        driver.navigate().back();
        driver.navigate().forward();

        WebElement brands=driver.findElement(By.xpath("//div[@class='brands_products']"));

        Actions actions=new Actions(driver);
        WebElement hedef=driver.findElement(By.xpath("//a[text()='Biba']"));
        actions.scrollToElement(hedef).perform();

        Assert.assertTrue(brands.isDisplayed());
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//a[text()='H&M']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Brand - H&M Products']")).
                getText().contains("H&M PRODUCTS"));










    }

}
