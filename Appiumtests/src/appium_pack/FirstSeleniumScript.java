package appium_pack;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class FirstSeleniumScript {
@Test
public static void kutta() throws InterruptedException{
System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
WebDriver driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://login.yahoo.com");
driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("edureka@yahoo.com");
Thread.sleep(2000);
System.out.println(driver.getTitle());
//Assert.assertEquals("Yahoo - login", driver.getTitle());
driver.close();
System.out.println("Pass");
} 
}