package com.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.BaseTest;
import com.qa.utils.TestUtils;

public class SignUpPage extends BaseTest {
	public String user_name;

	// Page Factory - Object Repository
	@FindBy(xpath = "//div[@class=\"sign-form\"]/h3")
	WebElement createNewAccountTxt;

	@FindBy(xpath="//div[@class=\"row\"]/descendant::div/a[contains(text(),'Sign Up')]")
	WebElement signUpHyperlink;

	@FindBy(id="user_username")
	WebElement usernameField;

	@FindBy(id="user_email")
	WebElement emailField;

	@FindBy(id="user_password")
	WebElement passwordField;

	@FindBy(id="user_password_confirmation")
	WebElement repeatPasswordField;

	@FindBy(id="agreement_is_age_confirmed")
	WebElement ageConfirmedCheckbox;

	@FindBy(id="agreement_is_accepted")
	WebElement acceptedCheckbox;

	@FindBy(id="mailing_system")
	WebElement mailingSystemCheckbox;

	@FindBy(id="mailing_product")
	WebElement mailingProductCheckbox;

	@FindBy(id="mailing_news")
	WebElement mailingNewsCheckbox;	

	@FindBy(xpath="//*[@id=\"recaptcha-anchor\"]")
	WebElement recaptchaCheckbox;

	@FindBy(xpath="//div[@class=\"recaptcha-checkbox-checkmark\"]")
	WebElement recaptchaCheckmark;

	@FindBy(xpath="//div[@class=\"form-group\"]/input[@value=\"Create Account\"]")
	WebElement createAccountBtn;   

	@FindBy(id="poll_company")
	WebElement companyField;

	@FindBy(id="poll_purpose")
	WebElement puposeDropdownField;

	@FindBy(xpath="//button[@type=\"submit\" and @class=\"btn btn-orange\"]")
	WebElement saveBtn;

	@FindBy(xpath="//a[@class=\"pull-right\" and @data-method=\"delete\"]/following-sibling::a[@class=\"pull-right\"]")
	WebElement helloUsernameField;

	// Initializing the Page Objects
	public SignUpPage() { 
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}

	public boolean validatecreateNewAccountTxt() {
		return createNewAccountTxt.isDisplayed();
	}

	public void signUpModule(String username, String pwd, String repwd, String email, String company) throws InterruptedException {
		try {
			signUpHyperlink.click();
			usernameField.sendKeys(username);
			emailField.sendKeys(email);
			passwordField.sendKeys(pwd);
			repeatPasswordField.sendKeys(repwd);
			//Use JavascriptExecutor for scrolling on the page
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)");
			List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
			for(int i =0; i<checkboxes.size(); i++)
			{
				checkboxes.get(i).click();
			}
			jse.executeScript("window.scrollBy(0,200)");

			// click on captcha checkbox by switching to the frame
			List<WebElement> frames = driver.findElements(By.tagName("iframe")); String
			winHanaleBefore = driver.getWindowHandle(); driver.switchTo().frame(0);
			driver.findElement(By.id("recaptcha-anchor")).click(); Thread.sleep(5000);
			driver.switchTo().window(winHanaleBefore);
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			createAccountBtn.click();
			companyField.sendKeys(company);

			// select 'Logistics' from the dropdown
			Select select = new Select(puposeDropdownField);
			select.selectByValue("Logistics");
			saveBtn.click();

			// split string and get username from the header
			String str = helloUsernameField.getText();
			String[] arr = str.split("Hello");
			user_name = arr[1].toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}