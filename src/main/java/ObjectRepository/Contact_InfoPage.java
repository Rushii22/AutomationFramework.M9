package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_InfoPage {
	
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement ContInfoheaderText;
	
	
	public Contact_InfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getContInfoEdt() {
		return ContInfoheaderText;
	}
	
	//Business library
	public String captureHeaderText()
	{
		return ContInfoheaderText.getText();
	}
	
	

}
