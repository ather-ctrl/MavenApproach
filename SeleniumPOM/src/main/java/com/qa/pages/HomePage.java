package com.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.BaseTest;

public class HomePage extends BaseTest{


	// Page Factory - Object Repository
	@FindBy(xpath = "//img[contains(@alt , 'Current weather')]")
	WebElement openWeatherLogoImage;
	
	@FindBy(xpath="//div[@class=\"row\"]/descendant::div/a[contains(text(),'Sign Up')]")
	WebElement signUpHyperlink;
		

	// Initializing the Page Objects
	public HomePage() { 
		PageFactory.initElements(driver, this);
	}


	// Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateOpenWeatherLogo() {
		return openWeatherLogoImage.isDisplayed();
	}

	//find brokenLinks from webpage
	public void verifyBrokenLinksHomeModule() {
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of Links: " + links.size());
		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){
			url = it.next().getAttribute("href");

			System.out.println(url);

			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(!url.startsWith(props.getProperty("url"))){
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	}

}