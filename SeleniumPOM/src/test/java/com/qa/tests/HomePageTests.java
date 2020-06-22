package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.qa.pages.HomePage;
import com.qa.BaseTest;

public class HomePageTests extends BaseTest {
	HomePage homePage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage(); 
	}

	@Test
	public void homePagePageTitleTest(){ 
		String homePageTitle = homePage.validateHomePageTitle();
		System.out.println("Home Page Title : " + homePageTitle);
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Сurrent weather and forecast - OpenWeatherMap");
	}

	@Test (enabled = false) 
	public void homePageLogoImageTest(){ boolean flag =
	homePage.validateOpenWeatherLogo(); Assert.assertTrue(flag); }

	@Test (enabled = false) 
	public void homePageBrokenLinksTest(){
		homePage.verifyBrokenLinksHomeModule(); }

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}