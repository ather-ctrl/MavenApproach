package appium_pack;                    //Enter your package name here.
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
public class Parameterization {                                    //This is an example script to illustrate the usage of parameterization feature of TestNG
@Test
@Parameters({"a","b"})
public static void add(int c, int d) {
int sum=c+d;
System.out.println("Sum of two numbers:"+sum);
}

}