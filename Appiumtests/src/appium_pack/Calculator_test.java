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

package appium_pack;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.By;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class Calculator_test {
	public static AppiumDriverLocalService server;
	public static AppiumDriver<MobileElement> driver;
	
	public static void main(String arr[]) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();                                    // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Samsung S9");                                          
		caps.setCapability("udid", "21d8732029047ece"); 										 //Device ID
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		caps.setCapability("noReset", "false");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps); // Set appium server address and port number in URL string and pass desired capabilities here.                                                            
		MobileElement two=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));                 //5 button
		two.click();
		MobileElement plus=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));               //add button
		plus.click();
		MobileElement four=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06"));                 //six button
		four.click();
		MobileElement equalTo=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));           //Equals button
		equalTo.click();
		MobileElement results=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));               //Storing the addition result 
		assert results.getText().equals("11"):"Actual value is : "+results.getText()+" did not match with expected value: 11";    //Pass or fail criteria
		driver.quit();                                                                                                            //close  
	}

}