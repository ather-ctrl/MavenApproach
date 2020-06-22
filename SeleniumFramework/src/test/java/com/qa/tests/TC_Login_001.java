package com.qa.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.BaseTest;
import com.qa.pages.LoginPage;

public class TC_Login_001 extends BaseTest{
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		logger.info("entered url");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSignin();
		logger.info("signin button clicked");
		System.out.println("all steps are performed successfully");	
		Thread.sleep(5000);
		String srt = driver.getTitle();
		//Assert.assertEquals(srt,"Find a Flight: Mercury Tours: "); 
	}

}
