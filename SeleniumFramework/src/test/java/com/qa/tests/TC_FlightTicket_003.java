package com.qa.tests;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.BaseTest;
import com.qa.pages.LoginPage;

public class TC_FlightTicket_003 extends BaseTest {
	
	@Test
	public void reservation() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSignin();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
		{
			//Assert.assertTrue(true);
			logger.info("login successfull");
		}
		else
		{
			//Assert.assertTrue(false);
			logger.info("login attempt error");
		}
		
		driver.findElement(By.xpath("(//input[@name='tripType'])[1]")).click();
		
		Select dropdown = new Select(driver.findElement(By.name("passCount")));
		dropdown.selectByValue("2"); 
		
		//Select dropdown1 = new Select(driver.findElement(By.name("fromPort")));
		//dropdown1.selectByVisibleText("San Francisco");
		
		Select dropdown2 = new Select(driver.findElement(By.name("fromMonth")));
		dropdown2.selectByVisibleText("June");
		
		Select dropdown3 = new Select(driver.findElement(By.name("fromDay")));
		dropdown3.selectByValue("21");
		
		Select dropdown4 = new Select(driver.findElement(By.name("toPort")));
		dropdown4.selectByVisibleText("New York");
		
		Select dropdown5 = new Select(driver.findElement(By.name("toMonth")));
		dropdown5.selectByVisibleText("July");
		
		Select dropdown6 = new Select(driver.findElement(By.name("toDay")));
		dropdown6.selectByValue("31");
		
		driver.findElement(By.xpath("(//input[@name='servClass'])[3]")).click();
		
		Select dropdown7 = new Select(driver.findElement(By.name("airline")));
		dropdown7.selectByVisibleText("Blue Skies Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//input[@name='outFlight'])[4]")).click();
		logger.info("departure flight selected");
		driver.findElement(By.xpath("(//input[@name='inFlight'])[4]")).click();
		logger.info("return flight selected");
		
		driver.findElement(By.name("reserveFlights")).click();
		logger.info("clicked on continue");
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("passFirst0")).sendKeys("bems");
		driver.findElement(By.name("passLast0")).sendKeys("id");
		
		Select dropdown8 = new Select(driver.findElement(By.name("pass.0.meal")));
		dropdown8.selectByVisibleText("Vegetarian");
		
		Select dropdown9 = new Select(driver.findElement(By.name("creditCard")));
		dropdown9.selectByVisibleText("Visa");
		
		driver.findElement(By.name("creditnumber")).sendKeys("4111111111111111");
		
		Select dropdown10 = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
		dropdown10.selectByIndex(6);
		
		Select dropdown11 = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
		dropdown11.selectByValue("2010");
		
		driver.findElement(By.name("cc_frst_name")).sendKeys("bems");
		driver.findElement(By.name("cc_last_name")).sendKeys("id");
		
		driver.findElement(By.xpath("(//input[@name='ticketLess'])[2]")).click();
		driver.findElement(By.name("buyFlights")).click();
		
		
		if(driver.getTitle().equals("Flight Confirmation: Mercury Tours"))
		{
			//Assert.assertTrue(true);
			logger.info("your flight has been confirmed");
		}
		else
		{
			//Assert.assertTrue(false);
			logger.info("your flight confirmation has not confirm");
		}
		
		
	}
	

}
