package Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1withDDT {

	public static void main(String[] args) throws Throwable {
		
		//Read all the required data
		/*Read common data from property file*/
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read test data from Excel file*/
		FileInputStream fes = new FileInputStream(".\\src\\main\\resources\\TestDataAS.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		String LASTNAME = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		//step 1:- launching the braowser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2:- load URL
		driver.get(URL);
		
		//step3:-login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys(PASSWORD,Keys.ENTER);
		
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
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//step10:-close the Browser
		driver.close();
		
		
		
		
	}

}
