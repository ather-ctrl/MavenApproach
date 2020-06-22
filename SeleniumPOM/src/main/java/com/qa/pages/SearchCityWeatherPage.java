package com.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.BaseTest;

public class SearchCityWeatherPage extends BaseTest {

	// Page Factory - Object Repository
	@FindBy(xpath="//button[@type=\"submit\" and @class=\"btn btn-orange\"]")
	WebElement searchFieldBtn;

	@FindBy(xpath="//input[@placeholder=\"Your city name\"]")
	WebElement inputCityField;

	@FindBy(xpath="//div[contains(text(),\"Not found\")]")
	WebElement notFoundTxt;

	@FindBy(id="forecast_list_ul")
	WebElement webTable;

	// Initializing the Page Objects
	public SearchCityWeatherPage() { 
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateSearchCityWeatherPageTitle() {
		return driver.getTitle();
	}

	public boolean validateNoFoundTxt() {
		return notFoundTxt.isDisplayed();
	}

	//searchBy Valid City
	public void searchByValidCity(String validCity) {	
		inputCityField.sendKeys(validCity);
		searchFieldBtn.click();		
	}

	//searchBy Invalid City
	public void searchByInValidCity(String invalidCity) {	
		inputCityField.sendKeys(invalidCity);
		searchFieldBtn.click();		
	}

	//search city from table from entering valid city
	public void selectCityFromTable() throws InterruptedException {
		try {
			WebElement webTable = driver.findElement(By.id("forecast_list_ul"));
			int rowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
			System.out.println("No. of rows: " + rowCount);
			List<WebElement> rowValues = webTable.findElements(By.tagName("tr"));
			List<WebElement> values = rowValues.get(1).findElements(By.tagName("td"));
			values.get(1).findElement(By.xpath("//table/tbody/tr/td[2]/b/a")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Message: " + e.getMessage());
		}		
	}


}