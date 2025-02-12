package ContactTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.WebDriverUtility;
import vtiger_ObjectFactory.ContactInforamtionPage;
import vtiger_ObjectFactory.ContactsPage;
import vtiger_ObjectFactory.CreateContactsPage;
import vtiger_ObjectFactory.CreateOrganizationPage;
import vtiger_ObjectFactory.HomePage;

@Listeners(GenericUtility.ListenersImplementation.class)
public class ToCreateContactWithOrgTest extends BaseClass {

	@Test(groups = "smoke")
	public void toCreateContact_005() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.getContact().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contact", 1, 2);
		ccp.getLastname().sendKeys(LASTNAME);
		// String parentId = driver.getWindowHandle();
		ccp.getCreateOrg().click();

		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toSwitchWindow(driver, "Accounts");
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getOrgnameInSwithPage().click();
		wutil.toSwitchWindow(driver, "Contacts&action");

		ccp.getSaveButton().click();
		ContactInforamtionPage cip = new ContactInforamtionPage(driver);
		String lastname = cip.getContactInformation().getText();
		Assert.assertTrue(lastname.contains(LASTNAME));
		Reporter.log(lastname + "----------passed", true);

	}
}
