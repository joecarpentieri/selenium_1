package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInShouldFailTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximises the window
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown(){ // closes the browser
        //driver.quit();
        // this is not used as often - driver.close();
    }
//three ways of finding an element below
    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        Thread.sleep(2000);
        // first way of doing it
        WebElement username = driver.findElement(By.name("username")); // finding the element by its name. Assigning it to WebElement with object reference as username. This line is saying, we want to find the element by the selenium locator 'name'.
        username.sendKeys("Admin"); //types admin into the username field

        //second way of doing it
        var password = driver.findElement(By.name("password")); // var infers datatype based on findelement
        password.sendKeys("admin123");

        //third way of doing it
        driver.findElement(By.tagName("button")).click(); // does not have an object reference
        Thread.sleep(2000); // not recommended in tests but just for demo
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertNotEquals(actualResult, expectedResult);
    }
}
