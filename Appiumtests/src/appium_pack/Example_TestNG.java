/*
 This is TestNG example script
 */

package appium_pack;                             //Enter your package name here.
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;       //Import annotations
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
 
public class Example_TestNG {

@Test                                                               //The annotated method is a part of a test case
 public void abc() {
 
 System.out.println("This is the A Normal Test Case");
 
 }
 
 @Test                                                               //The annotated method is a part of a test case
 public void def() {
 
 System.out.println("This is the A Normal Test Case2");
 
 }
 
 @Test                                                                  //The annotated method is a part of a test case
 public void ghi() {
 
 System.out.println("This is the A Normal Test Case3");
 
 }
 
 @BeforeMethod                                                        //The annotated method will be run before each test method.
 
 public void beforeMethod() {
 
 System.out.println("This will execute before every Method");
 
 }
 
 @AfterMethod                                                          //The annotated method will be run after each test method.
 
 public void afterMethod() {
 
 System.out.println("This will execute after every Method");
 
 }
 
 @BeforeClass                                                           //The annotated method will be run before the first test method in the current class is invoked.
 
 public void beforeClass() {
 
 System.out.println("This will execute before the Class");
 
 }
 
 @AfterClass                                                            //The annotated method will be run after all the test methods in the current class have been run.
 
 public void afterClass() {
 
 System.out.println("This will execute after the Class");
 
 }
 
 @BeforeTest                                                            //The annotated method will be run before any test method belonging to the classes inside the tag is run.
 
 public void beforeTest() {
 
 System.out.println("This will execute before the Test");
 
 }
 
 @AfterTest                                                           //The annotated method will be run after all the test methods belonging to the classes inside the tag have run.
 
 public void afterTest() {
 
 System.out.println("This will execute after the Test");
 
 }
 
 @BeforeSuite                                                          //The annotated method will be run before all tests in this suite have run
 
 public void beforeSuite() {
 
 System.out.println("This will execute before the Test Suite");
 
 }
 
 @AfterSuite                                                            // The annotated method will be run after all tests in this suite have run.
 
 public void afterSuite() {
 
 System.out.println("This will execute after the Test Suite");
 
 }
 
 }