package demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("1");
	}
 
	@BeforeClass
	public void beoforeClass() {
		System.out.println("2");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("3");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("4");
	}
	
	@Test
	public void test() {
		System.out.println("5");
	}
}
