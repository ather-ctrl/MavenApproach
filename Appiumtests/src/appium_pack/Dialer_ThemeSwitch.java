package appium_pack;

/*Test case description: To change the theme to dark theme.
 Test Script Name: TC_ThemeSwitch
 Test Steps: step1, step2, step3
 Test case ID: 0002
 Requirement ID: DRK0734
 Developer/Team member: 
 Last modified: DD/MM/YYYY
 Remarks(if any):*/


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import java.net.URL;
 
public class Dialer_ThemeSwitch {
	public static AppiumDriver<MobileElement> driver;
	public static void main(String arr[]) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();                                                              // Created object of DesiredCapabilities class.
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("udid", "A4030123435");                                                                         //Device ID
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "R");
		caps.setCapability("appPackage", "com.google.android.dialer");
		caps.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		caps.setCapability("noReset", "true");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);                            // Set appium server address and port number in URL string and pass desired capabilities here.
		MobileElement icon=driver.findElement(By.id("com.google.android.dialer:id/three_dot_menu_or_clear_icon_view"));    //three dots options
		Thread.sleep(1000);                                                                                                //Wait time in MS
		icon.click();
		MobileElement settings=driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));                 //Settings
		Thread.sleep(1000);
		settings.click();
		Thread.sleep(1000);
		MobileElement options=driver.findElement(By.xpath("//android.widget.TextView[@text='Display options']"));          //go to display options
		options.click();
		Thread.sleep(1000);
		MobileElement darktheme=driver.findElement(By.xpath("//android.widget.TextView[@text='Dark theme']"));              //Enable dark theme
		darktheme.click();
		Thread.sleep(1000);
		MobileElement sw=driver.findElement(By.xpath("//android.widget.Switch[@resource-id='android:id/switch_widget']"));
		MobileElement on=driver.findElement(By.xpath("//android.widget.Switch[@text='ON']"));
		Thread.sleep(1000);
		assert on.getText().equals("ON"):"Dark theme is not enabled";                                                        //Pass/fail Criteria
		MobileElement disable=driver.findElement(By.xpath("//android.widget.TextView[@text='Dark theme']"));                 //Enable back light theme 
		disable.click();
		driver.quit();                       //Close the app
			}
	
}

