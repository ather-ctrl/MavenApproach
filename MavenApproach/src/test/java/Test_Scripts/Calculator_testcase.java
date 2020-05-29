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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import page_objects.CalculatorUI;                                //Importing the page object here.

public class Calculator_testcase { 
	public static AppiumDriver<MobileElement> driver;
	private AppiumDriverLocalService service;
	@BeforeMethod                                                             //The annotated method will be run before each test method.
	public void setup() throws MalformedURLException {	
		startAppiumServer();
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
		service.stop();
	}

	public void startAppiumServer() {

		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH","/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/home/mohammedathera/linuxbrew/.linuxbrew/bin brew doctor export PATH=/home/mohammedathera/.linuxbrew/bin:”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin export MANPATH=/home/mohammedathera/.linuxbrew/share/man:”/home/mohammedathera/.linuxbrew/share/man:” export INFOPATH=/home/mohammedathera/.linuxbrew/share/info:”/home/mohammedathera/.linuxbrew/share/info:” export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/usr/lib/jvm/java-8-openjdk-amd64/bin export ANDROID_HOME=/home/mohammedathera/android-sdk export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/tools/bin export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/platform-tools export JAVA_OPTS='-XX:+IgnoreUnrecognizedVMOptions --add-modules java.se.ee' export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/ export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/home/mohammedathera/usr/bin/npm export PATH=~/.npm-global/bin:”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin export PATH=/home/mohammedathera/.npm-packages/bin:”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/home/mohammedathera/.npm-packages/bin:/home/mohammedathera/node-v6.9.2-linux-x64/bin:/.home/mohammedathera/node-v6.9.2-linux-x64/bin:/home/mohammedathera/Android/Sdk/tools:/home/mohammedathera/Android/Sdk/platform-tools" +System.getenv("PATH"));
		environment.put("ANDROID_HOME", "/home/mohammedathera/Android/sdk");
		environment.put("ANDROID_HOME", "/home/mohammedathera/Android/sdk/platform-tools");
		String nodePath = "/usr/local/bin/node";
		String appiumPath = "/home/mohammedathera/.npm-packages/lib/node_modules/appium/build/lib/main.js";
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.usingPort(4733)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withEnvironment(environment)
				.withAppiumJS(new File(appiumPath)));
		service.start();
	}


}


