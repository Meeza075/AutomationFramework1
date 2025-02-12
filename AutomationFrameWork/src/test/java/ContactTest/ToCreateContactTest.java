package ContactTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import vtiger_ObjectFactory.ContactInforamtionPage;
import vtiger_ObjectFactory.ContactsPage;
import vtiger_ObjectFactory.CreateContactsPage;
import vtiger_ObjectFactory.HomePage;

@Listeners(GenericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {

	@Test(groups = "smoke")
	public void toCreateContact_001() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.getContact().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contact", 1, 2);
		ccp.getLastname().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		Assert.fail();
		ContactInforamtionPage cip = new ContactInforamtionPage(driver);
		String lastname = cip.getContactInformation().getText();
		Assert.assertTrue(lastname.contains(LASTNAME));
		Reporter.log(lastname + "  ------------passed", true);

	}

}
