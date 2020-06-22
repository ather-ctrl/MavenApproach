package com.qa.tests;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

public class LoginTests {
	LoginPage loginPage;
	ProductsPage productsPage;
	BaseTest base; 

	@BeforeClass
	@Parameters({"platformName", "platformVersion", "deviceName"})
	public void beforeClass(String platformName, String platformVersion, String deviceName) throws Exception{
		base = new BaseTest();
		base.initializeDriver(platformName, platformVersion, deviceName);
	}

	@AfterClass
	public void afterClass() {
		base.quitDriver();
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		loginPage = new LoginPage();
		System.out.println("\n"+ "***** Starting test:"+ m.getName()+"*****" +"\n");	
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	@Test
	public void invalidUserName() {
		loginPage.enterUserName("invalidusername");
		loginPage.enterPassword("secrect_sauce");
		loginPage.pressLoginBtn();
		String actualErrTxt = loginPage.getErrTxt();
		String expectedErrTxt = "Username and password do not match any user in this service.";
		System.out.println("actual error txt - "+actualErrTxt+"\n"+"expected error txt --"+ expectedErrTxt);
		Assert.assertEquals(actualErrTxt, expectedErrTxt);
	}

	@Test
	public void invalidPassword() {
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("invalidpassword");
		loginPage.pressLoginBtn();
		String actualErrTxt = loginPage.getErrTxt();
		String expectedErrTxt = "Username and password do not match any user in this service.";
		System.out.println("actual error txt - "+actualErrTxt+"\n"+"expected error txt --"+ expectedErrTxt);
		Assert.assertEquals(actualErrTxt, expectedErrTxt);
	}

	@Test
	public void successfullLogin() {
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secrect_sauce");
		productsPage = loginPage.pressLoginBtn();
		//String actualProductTitle = productsPage.getTitile(productTitleTxt);
				//String expectedProductTitle = "PRODUCTS"
				//System.out.println("actual productpage tittle- "+actualProductTitle+"\n"+"expected productpagetitle --"+ expectedProductTitle);
				//Assert.assertEquals(actualProductTitle, expectedProductTitle);
	}
}
