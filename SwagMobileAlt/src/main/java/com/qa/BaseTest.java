package com.qa;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;
	public BaseTest(){

	}
	public void setDriver(AppiumDriver driver) {
		this.driver=driver;
	}

	public AppiumDriver getDriver() {
		return driver;

	}
	
	
	@BeforeTest
	public void initializeDriver(String platformName, String platformVersion, String deviceName) {
		try {	
			props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", deviceName);                                          									
			caps.setCapability("platformName", platformName);
			caps.setCapability("platformVersion", platformVersion);
			caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
			caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
			caps.setCapability("automationName", props.getProperty("androidAutomationName"));
			URL url = new URL(props.getProperty("appiumURL"));
			//URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
			//String appUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
			//caps.setCapability("app", appUrl);
			driver = new AndroidDriver(url,caps); 
			String sessionId = driver.getSessionId().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(e));

	}
	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}
	public void sendKeys(MobileElement e, String txt) {
		waitForVisibility(e);
		e.sendKeys(txt);
	} 
	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);

	}

	public void quitDriver() {
		driver.quit();
	}
}
