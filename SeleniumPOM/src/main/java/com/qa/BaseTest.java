package com.qa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.utils.TestUtils;

public class BaseTest {

	public static WebDriver driver;
	public static String baseUrl;
	public static Properties props;
	InputStream inputStream;
	
	public BaseTest(){
		try {
			props = new Properties();
			//FileInputStream is = new FileInputStream(System.getProperty("config.properties"));
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			//props.load(is);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialization() throws InterruptedException {		
		System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		driver.get(props.getProperty("url"));
	}
	
}