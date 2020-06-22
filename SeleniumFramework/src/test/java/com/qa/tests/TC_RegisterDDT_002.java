package com.qa.tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.pages.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utilities.XLUtils;


public class TC_RegisterDDT_002 extends BaseTest
{
	@Test(dataProvider="LoginData")
	public void registrationTest(String firstname, String lastname, String phone, String emailID, String address1,
	String address2, String city, String state, String zipcode, String country, String email,
	String password, String confirmPassword)
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.clickRegister();
		lp.setFirstName(firstname);
		lp.setLastName(lastname);
		lp.setPhone(phone);
		lp.setRegUserName(emailID);
		lp.setAddress1(address1);
		lp.setAddress2(address2);
		lp.setCity(city);
		lp.setState(state);
		lp.setPostalCode(zipcode);
		Select dropdown = new Select(driver.findElement(By.name("country")));
		dropdown.selectByVisibleText(country);
		lp.setEmail(email);
		lp.setRegPassword(password);
		lp.setConfirmPassword(confirmPassword);
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/resources/data/MercuryTestData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata [][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata [i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1 0
			}

		}
		return logindata;
	}
	

}
