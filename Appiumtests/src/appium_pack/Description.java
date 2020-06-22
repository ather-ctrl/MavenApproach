package appium_pack;                            //Enter your package name here.
import org.testng.annotations.Test;  
public class Description   
{  
      
@Test(description="This is my test case", invocationCount=5, priority=3)  
public void testcase1()           //This is an example script to illustrate the usage of description attribute of TestNG
{  
System.out.println("HR");  
}  
@Test(description="This is testcase2")  
public void testcase2()  
{  
System.out.println("Software Developer");  
}  
@Test(description="This is testcase3")  
public void testcase3()  
{  
System.out.println("QA Analyst");  
}  
}  