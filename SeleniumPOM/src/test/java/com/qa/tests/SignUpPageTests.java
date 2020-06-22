package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.SignUpPage;
import com.qa.utils.TestUtils;
import com.qa.BaseTest;

public class SignUpPageTests extends BaseTest {
	SignUpPage signUpPage;
	TestUtils testutil;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		signUpPage = new SignUpPage();
	}

	@Test(priority = 1)
	public void validateCreateNewAccountTxtTest() throws InterruptedException {

		boolean flag = signUpPage.validatecreateNewAccountTxt();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void signUpModuleTest() throws InterruptedException {
		signUpPage.signUpModule(props.getProperty("username"), props.getProperty("pwd"), 
				props.getProperty("repwd"), props.getProperty("email"),props.getProperty("company"));
		if(signUpPage.user_name.equalsIgnoreCase(props.getProperty("username"))) 
			System.out.println(signUpPage.user_name);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}