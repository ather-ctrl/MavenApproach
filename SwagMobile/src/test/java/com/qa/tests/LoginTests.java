package com.qa.tests;
import java.io.IOException;  //test
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

public class LoginTests extends BaseTest {
	LoginPage loginPage;
	ProductsPage productsPage;
	InputStream datais;
	JSONObject loginUsers;

	@BeforeClass
	public void beforeClass() throws Exception {
		try {
			String dataFileName = "data/loginUsers.json";
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(datais);
			loginUsers = new JSONObject(tokener);
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(datais != null) {
				datais.close();
			}
		}
		
	}

	@AfterClass
	public void afterClass() {
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
		loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
		loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("password"));
		loginPage.pressLoginBtn();
		String actualErrTxt = loginPage.getErrTxt();
		String expectedErrTxt = strings.get("err_invalid_username_or_password");
		System.out.println("actual error txt - "+actualErrTxt+"\n"+"expected error txt --"+ expectedErrTxt);
		Assert.assertEquals(actualErrTxt, expectedErrTxt);	
	}

	@Test
	public void invalidPassword() {
		loginPage.enterUserName(loginUsers.getJSONObject("invalidpassword").getString("username"));
		loginPage.enterUserName(loginUsers.getJSONObject("invalidpassword").getString("password"));
		loginPage.pressLoginBtn();
		String actualErrTxt = loginPage.getErrTxt();
		String expectedErrTxt = strings.get("err_invalid_username_or_password");
		System.out.println("actual error txt - "+actualErrTxt+"\n"+"expected error txt --"+ expectedErrTxt);
		Assert.assertEquals(actualErrTxt, expectedErrTxt);
	}

	@Test
	public void successfullLogin() {
		loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
		loginPage.enterUserName(loginUsers.getJSONObject("validuser").getString("password"));
		productsPage = loginPage.pressLoginBtn();
		//String actualProductTitle = productsPage.getTitile(productTitleTxt);
		//String expectedProductTitle = strings.get("product_title");
		//System.out.println("actual productpage tittle- "+actualProductTitle+"\n"+"expected productpagetitle --"+ expectedProductTitle);
		//Assert.assertEquals(actualProductTitle, expectedProductTitle);
	}
}
