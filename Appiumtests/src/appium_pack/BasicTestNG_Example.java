package appium_pack;                                                //Enter your package here
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BasicTestNG_Example {
 @BeforeMethod                                                      //The annotated method will be run before each test method.
  public void beforeMethod() {
      System.out.println("Launch the application");
  }
  @Test                                                               //The annotated method is a part of a test case
  public void gmailLogin() {
    System.out.println("Loggedin/Sigin in successfully");
  }
  @AfterMethod                                                        //The annotated method will be run after each test method
  public void afterMethod() { 
    System.out.println("Log out and close");  
  }
}