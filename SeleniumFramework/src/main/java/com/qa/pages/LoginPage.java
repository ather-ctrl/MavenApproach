package com.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.pages.BaseTest;

public class LoginPage extends BaseTest  {

WebDriver ldriver;

	  public LoginPage(WebDriver rdriver) 
	  { 
		  ldriver = rdriver;
	  PageFactory.initElements(rdriver, this); 
	  }
	 
	@FindBy(name="userName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="login")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="SIGN-OFF")
	@CacheLookup
	WebElement lnkSignOff;
	
	@FindBy(name="passCount")
	@CacheLookup
	WebElement numPassenger;
	
	
	public void setUserName (String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword (String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSignin()
	{
		btnLogin.click();
	}
	
	public void clickSignOff()
	{
		lnkSignOff.click();
	}
	
	@FindBy(linkText="REGISTER")
	@CacheLookup
	WebElement lnkRegister;
	
	@FindBy(name="firstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(name="lastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(name="phone")
	@CacheLookup
	WebElement numPhone;
	
	@FindBy(id="userName")
	@CacheLookup
	WebElement txtRegUserName;
	
	@FindBy(name="address1")
	@CacheLookup
	WebElement txtAddress1;
	
	@FindBy(name="address2")
	@CacheLookup
	WebElement txtAddress2;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="postalCode")
	@CacheLookup
	WebElement numPstCode;
	
	@FindBy(id="email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtRegPassword;
	
	@FindBy(name="confirmPassword")
	@CacheLookup
	WebElement txtConfirmPassword;
	
	@FindBy(name="register")
	@CacheLookup
	WebElement submitBtn;
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void setFirstName (String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName (String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setPhone (String phnnum)
	{
		numPhone.sendKeys(phnnum);
	}
	
	public void setRegUserName (String reguname)
	{
		txtRegUserName.sendKeys(reguname);
	}
	
	public void setAddress1 (String ad1)
	{
		txtAddress1.sendKeys(ad1);
	}
	
	public void setAddress2 (String ad2)
	{
		txtAddress2.sendKeys(ad2);
	}
	public void setCity (String cityn)
	{
		txtCity.sendKeys(cityn);
	}
	public void setState (String staten)
	{
		txtState.sendKeys(staten);
	}
	public void setPostalCode (String postal)
	{
		numPstCode.sendKeys(postal);
	}
	public void setEmail (String regemail)
	{
		txtEmail.sendKeys(regemail);
	}
	public void setRegPassword (String regpwd)
	{
		txtRegPassword.sendKeys(regpwd);
	}
	public void setConfirmPassword (String cnfpwd)
	{
		txtConfirmPassword.sendKeys(cnfpwd);
	}
	public void clickSubmit()
	{
	submitBtn.click();
	}
	public void selectVlaueFromDropdown(WebElement element, String value)
	{
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);	
	}
}
