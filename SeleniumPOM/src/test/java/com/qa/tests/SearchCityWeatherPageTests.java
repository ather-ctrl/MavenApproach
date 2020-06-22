package com.qa.tests;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.SearchCityWeatherPage;
import com.qa.utils.TestUtils;
import com.qa.BaseTest;

public class SearchCityWeatherPageTests extends BaseTest {

	SearchCityWeatherPage searchCityWeather;
	TestUtils testutil;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		searchCityWeather = new SearchCityWeatherPage();
	}

	@Test (priority = 1) 
	public void searchByValidCityTest() throws InterruptedException {
		searchCityWeather.searchByValidCity(props.getProperty("validCity"));
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		searchCityWeather.selectCityFromTable(); 
	}

	@Test(priority = 2)
	public void searchByInvalidCityTest() {
		searchCityWeather.searchByInValidCity(props.getProperty("invalidCity"));
		boolean flag = searchCityWeather.validateNoFoundTxt();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}