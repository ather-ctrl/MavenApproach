package appium_pack;                            //Enter your package name here.
import org.testng.Assert;  
import org.testng.annotations.Test;  
import org.testng.asserts.SoftAssert;  
public class SoftAndHard_Assertion {

SoftAssert soft_assert=new SoftAssert();  
@Test  
public void Soft_Assert()        //This is an example script to illustrate the usage of soft and hard assert
{  
 soft_assert.assertTrue(false);  
 System.out.println("soft assertion");  
}  
@Test  
public void Hard_Assert()  
{  
 Assert.assertTrue(false);  
 System.out.println("hard assertion");  
}  
}  