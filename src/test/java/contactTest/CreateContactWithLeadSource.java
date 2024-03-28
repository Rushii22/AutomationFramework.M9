package contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.Contact_InfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreatingNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericutilities.BaseClass;
import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.SeleniumUtility;

public class CreateContactWithLeadSource extends BaseClass {

	@Test(groups = "RegresionSuite")
	public void CreateContactWithLead() throws Throwable {

		
		
		/*Read test data from Excel file*/
		 String LASTNAME = eUtil.readDataFromExcel("Sheet1", 1, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Sheet1", 4, 3);
		 
		//step1:-click on contact link
		HomePage hp = new HomePage(driver);
		hp.clickoncontactlink();
		
		//step 2:- click on creat contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncertcontactLookImage();
		
		//step 3:- Enter Mandatory fields
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.creatNewContact(LASTNAME, LEADSOURCE);
		
		//step4:- validation
		Contact_InfoPage cip = new Contact_InfoPage(driver);
		String contactHeader=cip.captureHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
	
	
}	


	
	
}
