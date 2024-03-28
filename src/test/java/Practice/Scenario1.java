package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		
		//step 1:- launching the braowser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//step 2:- load URL
		driver.get("http://localhost:8888/");
		
		//step3:-login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("admin",Keys.ENTER);
		
		//step4:-click on contact link
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		
		//step 5:- click on creat contact look up image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//step 6:- Enter Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Jain");
		
		//step7:- save
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//step8:- validation
		//contact is successfully created or not
		String contactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		System.out.println(contactHeader);
		
		if(contactHeader.contains("Jain"))
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
