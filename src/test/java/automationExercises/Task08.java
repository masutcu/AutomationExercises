package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task08 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
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
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    @Test
    public void test2(){
        List<WebElement> urunList=driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        for(WebElement w:urunList){
           Assert.assertTrue( w.isDisplayed());
        }
        urunList.stream().forEach(t-> System.out.println(t.getText()));
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();


    }
    //9. Verify that  detail is visible: product name, category, price, availability, condition, brand
    @Test
    public void test3(){
        WebElement productName=driver.findElement(By.xpath("(//h2)[3]"));
        WebElement catagory=driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
        WebElement price=driver.findElement(By.xpath("(//span)[13]"));
        WebElement availability=driver.findElement(By.xpath("//b[text()='Availability:']"));
        WebElement ccndition=driver.findElement(By.xpath("//b[text()='Condition:']"));
        WebElement brand=driver.findElement(By.xpath("//b[text()='Brand:']"));

        List<WebElement> arananBaslıklar=new ArrayList<>(Arrays.asList(productName,catagory,price,availability,ccndition,brand));
        arananBaslıklar.stream().forEach(t->Assert.assertTrue(t.isDisplayed()));

        //Assert.assertTrue(productName.isDisplayed() && catagory.isDisplayed() && price.isDisplayed()
        //&& availability.isDisplayed() && ccndition.isDisplayed() && brand.isDisplayed());


    }
}
