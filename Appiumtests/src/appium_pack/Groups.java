package appium_pack;                     //Enter your package name here.
 
import org.testng.annotations.Test;  
public class Groups               //This is an example script to illustrate the usage of groups attribute of TestNG
{  
@Test(groups= {"software company"})  
public void infosys()  
{  
System.out.println("Infosys");  
}  
@Test  
public void technip()  
{  
System.out.println("Technip India Ltd");  
}  
@Test(groups= {"software company"})  
public void wipro()  
{  
System.out.println("Wipro");  
}  
}  