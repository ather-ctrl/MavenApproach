package appium_pack;             //Enter your package name here.

import org.testng.annotations.Test;  
public class TimeOut 
{  
@Test(timeOut=200)            //This is an example script to illustrate the usage of timeOut attribute of TestNG
public void testcase1() throws InterruptedException  
{  
Thread.sleep(500);  
System.out.println("This is testcase1");  
}  
@Test    
public void testcaes2()  
{  
System.out.println("This is testcase2");  
    }  
@Test  
public void testcase3()  
{  
System.out.println("This is testcase3");  
}  
}  