package appium_pack;                            //Enter your package name here.

import org.testng.annotations.Test;  
public class Priotity  
{   
@Test(priority=3)
public void mango()          //This is an example script to illustrate the usage of priority attribute of TestNG
{  
System.out.println("I am Mango");  
}  
@Test(priority=2)
public void apple()  
{  
System.out.println("I am Apple");  
}  
@Test(priority=1)
public void watermelon()  
{  
System.out.println("I am Watermelon");  
}  
}  