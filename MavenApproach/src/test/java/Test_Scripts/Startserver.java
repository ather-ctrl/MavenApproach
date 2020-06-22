package Test_Scripts;

import java.io.File;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Startserver {
	private AppiumDriverLocalService service;
	String nodePath = null;
	String appiumPath = null;
	@Test
	public void startAppiumServer() {
		//HashMap<String, String> environment = new HashMap<String, String>();
		//environment.put("PATH","/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/home/mohammedathera/linuxbrew/.linuxbrew/bin brew doctor export PATH=/home/mohammedathera/.linuxbrew/bin:”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin export MANPATH=/home/mohammedathera/.linuxbrew/share/man:”/home/mohammedathera/.linuxbrew/share/man:” export INFOPATH=/home/mohammedathera/.linuxbrew/share/info:”/home/mohammedathera/.linuxbrew/share/info:” export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/usr/lib/jvm/java-8-openjdk-amd64/bin export ANDROID_HOME=/home/mohammedathera/android-sdk export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/tools/bin export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/platform-tools export JAVA_OPTS='-XX:+IgnoreUnrecognizedVMOptions --add-modules java.se.ee' export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/ export PATH=”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/home/mohammedathera/usr/bin/npm export PATH=~/.npm-global/bin:”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin export PATH=/home/mohammedathera/.npm-packages/bin:”/home/mohammedathera/.linuxbrew/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64:/usr/lib/jvm/java-8-openjdk-amd64/bin:$/usr/bin/java:/home/mohammedathera/workspace/apache-ant-1.10.5/bin:/home/mohammedathera/workspace/apache-maven-3.6.1/bin”:/home/mohammedathera/.linuxbrew/bin:/home/mohammedathera/.npm-packages/bin:/home/mohammedathera/node-v6.9.2-linux-x64/bin:/.home/mohammedathera/node-v6.9.2-linux-x64/bin:/home/mohammedathera/Android/Sdk/tools:/home/mohammedathera/Android/Sdk/platform-tools" +System.getenv("PATH"));
		//environment.put("ANDROID_HOME", "/home/mohammedathera/Android/sdk");
		//environment.put("ANDROID_HOME", "/home/mohammedathera/Android/sdk/platform-tools");
		//String nodePath = "/usr/local/bin/node";
		//String appiumPath = "/home/mohammedathera/.npm-packages/lib/node_modules/appium/build/lib/main.js";
		nodePath = "/usr/local/bin/node";
		appiumPath = "/home/mohammedathera/.npm-packages/lib/node_modules/appium/build/lib/main.js";
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.usingPort(4723)
				//.withEnvironment(environment)
				.withAppiumJS(new File(appiumPath)));
		service.start();
System.out.println("Started the server");
	}
}
