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

public class Task18 {
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that categories are visible on left side bar
        //4. Click on 'Women' category
        //5. Click on any category link under 'Women' category, for example: Dress
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        //7. On left side bar, click on any sub-category link of 'Men' category
        //8. Verify that user is navigated to that category page

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
    public void test18() throws InterruptedException {
        WebElement catagory = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(catagory.isDisplayed());

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Women']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='Dress '])[1]")).click();
        //çıkan reklamı atlamak için
        driver.navigate().back();
        driver.navigate().forward();

        WebElement catagoryText=driver.findElement(By.xpath("//h2[text()='Women - Dress Products']"));
        Assert.assertTrue(catagoryText.getText().contains("WOMEN - DRESS PRODUCTS"));
        WebElement hedef=driver.findElement(By.xpath("//a[@href='#Men']"));

        actions.scrollToElement(hedef).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        hedef.click();
        driver.findElement(By.xpath("//a[text()='Jeans ']")).click();
        Thread.sleep(2000);
        String jeansText=driver.findElement(By.xpath("//h2[text()='Men - Jeans Products']")).getText();
        Assert.assertTrue(jeansText.contains("JEANS PRODUCTS"));








    }
}
