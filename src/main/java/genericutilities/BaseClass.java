package genericutilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * 
 * This class consists of all basic configuration of TestNG
 */
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	//for Listener
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups = {"SmokeSuite", "RegresionSuite"})
	public void bsConfig()
	{
		System.out.println("----DB Connection Succesfully----");
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String Browser*/) throws Throwable
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
	/*	if(Browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
	*/	
		sUtil.maximizewindow(driver);
		sUtil.addimplicitilywait(driver);
		
		driver.get(URL);
		
		System.out.println("----Browser Launch Succesfully----");

		//for Listeners
		sdriver=driver;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----Login To App Succesfully----");

	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("----Logout of App Succesfully----");

	}
	
	//@Parameters("Browser")
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("----Browser closed Succesfully----");

	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("----DB Closed Succesfully----");

	}

}
