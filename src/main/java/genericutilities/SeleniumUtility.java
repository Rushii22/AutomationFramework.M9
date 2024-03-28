package genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility {
	/**
	 * @param driver
	 */

	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void miniizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void addimplicitilywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * 
	 * @param element
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropdown( String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightclickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollby(0,500);", "");
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollby(0,-500);", "");
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollRightAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollby(50,0);", "");
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollLeftAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollby(-50,0);", "");
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String value = driver.switchTo().alert().getText();
		return value;
	}
	/**
	 * 
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * 
	 * @param driver
	 * @param screenshot
	 * @throws IOException 
	 */
	 public String capture_ScreenShot(WebDriver driver, String screenshotName) throws IOException
	 {
		TakesScreenshot  ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShot\\"+screenshotName+".png");
	 
		Files.copy(scr, dest);
		return dest.getAbsolutePath(); //extent Report
	 }

	
	
}
