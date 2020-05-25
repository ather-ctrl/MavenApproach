/*
 Test Case Description: validate the sum of two numbers.
 Test Script Name: TC_Calculator
 Test Steps: Step1, Step2, Step3
 Test Case ID: 54321
 Requirement ID: CAL0734
 Developer/Team member: 
 Last modified: DD/MM/YYYY
 Remarks(If any):
 */
package Test_Scripts;                                     //Enter your package name here.
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import page_objects.CalculatorUI;                                //Importing the page object here.

public class Calculator_testcase { 
	public static AppiumDriver<MobileElement> driver;
	@BeforeMethod                                                             //The annotated method will be run before each test method.
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();                                    // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Samsung S9");                                          
		caps.setCapability("udid", "21d8732029047ece"); 										 //Device ID
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		caps.setCapability("noReset", "true");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps); // Set appium server address and port number in URL string and pass desired capabilities here.                                                            
	}

	@Test                                                     //The annotated method is a part of a test case
	public void sum() throws InterruptedException 
	{
		CalculatorUI calci = new CalculatorUI(driver);        //Created the object of page CalculatorUI
		
		calci.clickonfive();
		calci.clickonadd();
		calci.clickonsix();
		calci.clickonequal();
		String s= calci.showresult();
		assert s.equals("11"):"Actual value is : "+s.equals(s)+" did not match with expected value: 11";   //pass/fail criteria
	}
	@AfterMethod	 
	public void appclose() {
		driver.quit();                                                                                     //close the application
	}

}


