package contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.Contact_InfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreatingNewContactPage;
import ObjectRepository.HomePage;
import genericutilities.BaseClass;

@Listeners(genericutilities.ListenersImplementation.class)
public class CreatecontactTest extends BaseClass {
  
	@Test(groups = "SmokeSuite")
	public void CreatecontactWithMandInfo() throws Throwable {
	
		/*Read test data from Excel file*/
		 String LASTNAME = eUtil.readDataFromExcel("Sheet1", 1, 2);
		
		//step1:-click on contact link
		HomePage hp = new HomePage(driver);
		hp.clickoncontactlink();
		
		//step 2:- click on creat contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncertcontactLookImage();
		
		//step 3:- Enter Mandatory fields
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.creatNewContact(LASTNAME);
		
		//step4:- validation
		Contact_InfoPage cip = new Contact_InfoPage(driver);
		String contactHeader=cip.captureHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
			
		
}	
	
	@Test
	public void demoTest()
	{
		//Assert.fail();
		System.out.println("Hii");
	}

}
