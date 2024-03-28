package Practice;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void sample()
	{
		System.out.println("Hii");
		
	}
	
	@Test(invocationCount = 2)
	public void Sam()
	{
		
		System.out.println("Hello");
	}


}
