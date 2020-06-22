package com.qa.pages;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage{
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding=sibling::android.view.ViewGroup/android.widget.TextView") private MobileElement productTitleTxt ;

	BaseTest base;
	public ProductsPage(){
		base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}
public ProductsPage getTitile(MobileElement productTitleTxt) {
	base.getAttribute(productTitleTxt, "text");
	return this;
}

}


