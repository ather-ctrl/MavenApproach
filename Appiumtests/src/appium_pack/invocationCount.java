package appium_pack;                   //Enter your package name here.

import org.testng.annotations.Test;

public class invocationCount {           
	                                    //This is an example script to illustrate the usage of invocationCount attribute of TestNG
	@Test(invocationCount=5)  
	public void testcaes2()  
	{  
	System.out.println("This is testcase2");  
	    }  
	@Test(invocationCount=3)   
	public void testcase3()  
	{  
	System.out.println("This is testcase3");  
	} 

}
