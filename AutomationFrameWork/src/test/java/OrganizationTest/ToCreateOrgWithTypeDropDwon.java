package OrganizationTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.WebDriverUtility;
import vtiger_ObjectFactory.CreateOrganizationPage;
import vtiger_ObjectFactory.HomePage;
import vtiger_ObjectFactory.OraganizationInformationPage;
@Listeners(GenericUtility.ListenersImplementation.class)
public class ToCreateOrgWithTypeDropDwon extends BaseClass{
	@Test(groups="regression")
	public void toCreateOrg_004() throws IOException {
	HomePage hp= new HomePage(driver);
	   hp.getOrganization().click();
	   CreateOrganizationPage cp = new CreateOrganizationPage(driver);
	   cp.getCreateorganization().click();
	   
	   ExcelFileUtility eutil= new ExcelFileUtility();
	   String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);
	   
		cp.getOraganizationname().sendKeys(ORGNAME+cp.ramdom);
		WebElement INDUSTRY = cp.getIndustryDropDwon();
		WebElement TYPE = cp.getTypeDropDwon();
		WebDriverUtility wutil= new WebDriverUtility();
		
		wutil.toHandleDropDown(INDUSTRY, "Chemicals");
		wutil.toHandleDropDown(TYPE, "Customer");
	   cp.getSaveButton().click();
	   OraganizationInformationPage oip= new OraganizationInformationPage(driver);
	   String orgname=oip.getOrganizationInformation().getText();
	   Assert.assertTrue(orgname.contains(ORGNAME));
	   Reporter.log(orgname+"----------passed",true);
	  
	}
}
