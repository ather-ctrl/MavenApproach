package appium_pack;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.net.URL;

public class Login_LogoutSpear {
	public static AppiumDriver<MobileElement> driver;
	public static void main(String arr[]) throws Exception {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Samsung S9");
			caps.setCapability(MobileCapabilityType.UDID, "21d8732029047ece"); 
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability("appPackage", "com.evolgence.on");
			caps.setCapability("appAcitvity", "myspear.ui.DashboardNavigationActivity");
			caps.setCapability("noReset", "true");
			driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			Thread.sleep(3000);
			MobileElement sigin=driver.findElement(By.id("com.evolgence.on:id/btn_signin"));
			sigin.click();
			MobileElement username= driver.findElement(By.id("com.evolgence.on:id/edt_username"));
			username.sendKeys("1171200001");
			MobileElement password = driver.findElement(By.id("com.evolgence.on:id/edt_password"));
			password.sendKeys("spear@1234");
			MobileElement submit=driver.findElement(By.id("com.evolgence.on:id/btn_submit"));
			submit.click();
			Thread.sleep(3000);
			MobileElement edt_com=driver.findElement(By.id("com.evolgence.on:id/edt_company"));
			MobileElement edt_mobile =driver.findElement(By.id("com.evolgence.on:id/edt_mobile"));
			MobileElement edt_email =driver.findElement(By.id("com.evolgence.on:id/edt_email"));
			MobileElement next=driver.findElement(By.id("com.evolgence.on:id/btn_next"));
			next.click();
			Thread.sleep(8000);
			MobileElement layout=driver.findElement(By.id("com.evolgence.on:id/swipeselector_layout_swipePager"));
			MobileElement view=driver.findElement(By.className("androidx.recyclerview.widget.RecyclerView"));
			MobileElement navigation=driver.findElement(By.id("com.evolgence.on:id/navigation_apps"));
			Thread.sleep(2000);
			MobileElement profile=driver.findElementByAccessibilityId("Profile");
			MobileElement sub=driver.findElement(By.id("com.evolgence.on:id/txtSubTitle"));
			MobileElement about=driver.findElement(By.xpath("//android.widget.TextView[@text='About']"));
			MobileElement logout=driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']"));
			logout.click();
			MobileElement alert=driver.findElement(By.id("com.evolgence.on:id/alertTitle"));
			MobileElement send=driver.findElement(By.id("android:id/message"));
			MobileElement msg=driver.findElement(By.id("android:id/button2"));
			MobileElement msg21=driver.findElement(By.id("android:id/button1"));
			msg21.click();
			Thread.sleep(4500);
			MobileElement otp1=driver.findElement(By.id("com.evolgence.on:id/btn_otp"));
			MobileElement btn1=driver.findElement(By.id("com.evolgence.on:id/btn_signin"));
			driver.quit();
	}
}