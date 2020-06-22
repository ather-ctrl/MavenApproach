package com.qa.pages;
import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BaseTest{
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding=sibling::android.view.ViewGroup/android.widget.TextView") 
	private MobileElement productTitleTxt ;

public ProductsPage getTitile(MobileElement productTitleTxt) {
	getAttribute(productTitleTxt, "text");
	return this;
}

}


