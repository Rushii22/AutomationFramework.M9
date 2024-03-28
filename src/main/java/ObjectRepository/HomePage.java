package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	
	@FindBy(xpath = "//a[text()=\"Contacts\"]")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	
	public HomePage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsEdt() {
		return contactLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	//business library
	public void clickoncontactlink()
	{
		contactLink.click();
	}
	public void logoutOfApp(WebDriver driver)
	{
		mouseoverAction(driver, administratorImg);;
		signout.click();
	}
	
	
	
	
	
}
