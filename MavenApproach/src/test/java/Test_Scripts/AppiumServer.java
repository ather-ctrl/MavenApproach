package Test_Scripts;

import java.io.IOException;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {
private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
static void startAppiumServer() throws IOException, InterruptedException{
	service.start();
}
	
	static void stopAppiumServer() throws IOException, InterruptedException{
		service.stop();
	}
	
}
