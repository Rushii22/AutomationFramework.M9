package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.SeleniumUtility;

public class CreatingNewContactPage extends SeleniumUtility{
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourcrdropdown;
	
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCrtNewContEdt() {
		return lastnameEdt;
	}
	
	public WebElement getLeadsourcrEdt() {
		return leadsourcrdropdown;
	}

	public WebElement getSave() {
		return saveBtn;
	}
	
	public void creatNewContact(String LASTNAME) 
	{
		lastnameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	public void creatNewContact(String LASTNAME, String LEADSOURCE)
	{
		lastnameEdt.sendKeys(LASTNAME);
		handleDropdown(leadsourcrdropdown, LEADSOURCE);
		saveBtn.click();
	}
		
}
