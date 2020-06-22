package com.qa.pages;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage{
	@AndroidFindBy(accessibility = "test-Username") private MobileElement usernameTxtFld;
	@AndroidFindBy(accessibility = "test-Password") private MobileElement passwordTxtFld;
	@AndroidFindBy(accessibility = "test-LOGIN") private MobileElement loginBtn;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") private MobileElement errTxt ;

	BaseTest base;
	public LoginPage(){
		base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}
public LoginPage enterUserName(String username) {
	base.sendKeys(usernameTxtFld, username);
	return this;
}

public LoginPage enterPassword(String password) {
	base.sendKeys(passwordTxtFld,password);
	return this;
}
public ProductsPage pressLoginBtn() {
	base.click(loginBtn);
	return new ProductsPage();
}

public String getErrTxt() {
	return base.getAttribute(errTxt, "text");
}
	
}


