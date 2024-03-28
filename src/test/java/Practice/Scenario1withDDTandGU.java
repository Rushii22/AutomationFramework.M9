package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;
import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.SeleniumUtility;

public class Scenario1withDDTandGU {
	
	@Test
	public void Sce1()  throws Throwable {

				//create object Utility
				PropertyFileUtility pUtil = new PropertyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();
				SeleniumUtility sUtil = new SeleniumUtility();
		
				//Read all the required data
				/*Read common data from property file*/
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				/*Read test data from Excel file*/
				 String LASTNAME = eUtil.readDataFromExcel("Sheet1", 1, 2);
				
				//step 1:- launching the braowser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizewindow(driver);
				sUtil.addimplicitilywait(driver);
				
				//step 2:- load URL
				driver.get(URL);
				
				//step3:-login to application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//WebElement pass = driver.findElement(By.name("user_password"));
				//pass.sendKeys(PASSWORD,Keys.ENTER);
				
				LoginPage lp = new LoginPage(driver);
			/*	lp.getUsernameEdt().sendKeys(USERNAME);
				lp.getPasswordedt().sendKeys(PASSWORD);
				lp.getLoginBtn().click();
			*/	
				lp.loginToApp(USERNAME, PASSWORD);
				
				
				//step4:-click on contact link
				driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
				
				//step 5:- click on creat contact look up image
				driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
				
				//step 6:- Enter Mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//step7:- save
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
				
				//step8:- validation
				//contact is successfully created or not
				String contactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				System.out.println(contactHeader);
				
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println("Pass");

				}
				else 
				{
					System.out.println("Fail");

				}
				
				//step9:-logout from application
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				sUtil.mouseoverAction(driver, ele);
				
				Thread.sleep(1000);
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				//step10:-close the Browser
				driver.close();
				
	}	
		

}
