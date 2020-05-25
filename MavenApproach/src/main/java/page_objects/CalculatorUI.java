/*
This page contains page objects elements for CalculatorUI
 */

package page_objects;                         //Enter your Package name.
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorUI {
	public static AppiumDriver<MobileElement> driver;
  
    public CalculatorUI(AppiumDriver<MobileElement> driver) {
        CalculatorUI.driver =  driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")
    private AndroidElement five;
    public void clickonfive() {
    	five.click();
    }
    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")
    private AndroidElement add;
    public void clickonadd() {
    	add.click();
    }
    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")
    private AndroidElement six;
    public void clickonsix() {
    	six.click();
    }
    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")
    private AndroidElement equal;
    public void clickonequal() {
    	equal.click();
    }
    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/calc_edt_formula")    //
    private AndroidElement result;
    public String showresult() {
		return result.getText();
    	
    }
   
}