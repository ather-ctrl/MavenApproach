package appium_pack;

import org.testng.annotations.Test;  
public class DependsOn           //This is an example script to illustrate the usage of DependsOnMethods attribute of TestNG
{  
@Test  
public void WebStudentLogin()  
{  
System.out.println("Student login through web");  
}  
@Test  
public void MobileStudentLogin()  
{  
System.out.println("Student login through mobile");  
}  
@Test(dependsOnMethods= {"WebStudentLogin"})  
public void APIStudentLogin()  
{  
System.out.println("Student login through API");  
}  
}  