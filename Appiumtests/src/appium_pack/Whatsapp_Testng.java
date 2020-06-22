/*
 Test case description: Setting up a whatsapp status, validate and delete.
 Test Script Name: TC_whatapp_status
 Test Steps: step1, step2, step3
 Test case ID: 1234
 Requirement ID: WT0734
 Developer/Team member: 
 Last Modified: DD/MM/YYYY
 Remarks(if any):
 */

package appium_pack;                                                             //Enter your package name here
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Whatsapp_Testng{
	
	public static AppiumDriver<MobileElement> driver;
	@BeforeMethod                                                              //The annotated method will be run before each test method.
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();                 // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Samsung S9");                 
		caps.setCapability("udid", "21d8732029047ece");                             //Device ID
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability("appPackage", "com.whatsapp");
		caps.setCapability("appActivity", "com.whatsapp.HomeActivity");
		caps.setCapability("noReset", "true");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps); // Set appium server address and port number in URL string and pass desired capabilities here.  
		System.out.print("Launch the application");
	}

	 @Test                                                                //The annotated method is a part of a test case
	 public void testCase() throws InterruptedException {
	 System.out.println("Test execution started");
	 MobileElement status=driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.TextView[@text='STATUS']"));
		status.click();                                                                    //Clicking on status tab in main screen
		Thread.sleep(300);
		MobileElement n=driver.findElement(By.id("com.whatsapp:id/fab_aux"));
		n.click();
		Thread.sleep(300);
		MobileElement color=driver.findElement(By.id("com.whatsapp:id/color_picker_btn"));   //changing the background color
		color.click();
		Thread.sleep(1500);                                                               //Wait time in milli seconds
		color.click();
		MobileElement type=driver.findElement(By.id("com.whatsapp:id/entry"));
		Thread.sleep(500);
		type.click();
		type.sendKeys("Have a nice day!");                                                  //input text
		Thread.sleep(2000);
		MobileElement send=driver.findElement(By.id("com.whatsapp:id/send"));                //Sending the status
		send.click();
		Thread.sleep(2000);
		MobileElement action=driver.findElement(By.id("com.whatsapp:id/action_icon"));
		action.click();
		Thread.sleep(500);
		MobileElement flow=driver.findElement(By.id("com.whatsapp:id/overflow_icon"));        //checking the status, if sent or not
		flow.click();
		Thread.sleep(500);
		MobileElement del=driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.TextView[@text='Delete']"));
		Thread.sleep(600);
		del.click();                                                                         //Delete the status
		Thread.sleep(400);
		MobileElement msg=driver.findElement(By.id("android:id/message"));                   //Validating the message in pop up
		MobileElement cancel=driver.findElement(By.id("android:id/button2"));                //Cancel button Validation
		MobileElement ok = driver.findElement(By.id("android:id/button1"));                  //Delete button validation
		ok.click();
		Thread.sleep(200);
		 System.out.println("Test execution End here");
		 
		 
	 }
	  @AfterMethod                                                                           //The annotated method will be run after each test method.
	  public void afterMethod() {
	    System.out.println("Closing the application"); 
	    driver.quit(); 
	  }
	 
}
