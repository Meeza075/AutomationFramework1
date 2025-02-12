package OrganizationTest;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import vtiger_ObjectFactory.CreateOrganizationPage;
import vtiger_ObjectFactory.HomePage;
import vtiger_ObjectFactory.OraganizationInformationPage;
@Listeners(GenericUtility.ListenersImplementation.class)
public class ToCreateOrgTest extends BaseClass {

	@Test(groups="regression")
	public void toCreateOrg_002() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		cp.getCreateorganization().click();

		ExcelFileUtility eutil = new ExcelFileUtility();
		Random r = new Random();
		int random = r.nextInt(1000);
		String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2)+random;

		cp.getOraganizationname().sendKeys(ORGNAME);
		cp.getSaveButton().click();
		OraganizationInformationPage oip = new OraganizationInformationPage(driver);
		String orgname = oip.getOrganizationInformation().getText();
		Assert.assertTrue(orgname.contains(ORGNAME));
		Reporter.log(ORGNAME + "-----------passed", true);

	}
}
