package Practice;
/**
 * This class is used to perform 
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import vtiger_ObjectFactory.ContactInforamtionPage;
import vtiger_ObjectFactory.ContactsPage;
import vtiger_ObjectFactory.CreateContactsPage;
import vtiger_ObjectFactory.HomePage;
import vtiger_ObjectFactory.LoginPage;

public class DemoScripWithDDTandGU {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//To read data from propertyfile
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		//To read data from Excel file
		String LASTNAME = eutil.toReadDataFromExcelFile("Contact", 1, 2);
		//Step 1: Lunch Browser
		WebDriver driver=null;
		if(BROWSER.contains("chrome")) {
			driver=new ChromeDriver();
			}else if(BROWSER.contains("edge")) {
				driver=new EdgeDriver();
			}else if(BROWSER.contains("firefox")) {
				driver=new FirefoxDriver();
			}
		
		wutil.toMaximize(driver);
		wutil.towaitForElements(driver);
	
		
		//Step 2: login to application with valid credentials
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextfield().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		//step 3: Navigate to contacts link
		HomePage hp= new HomePage(driver);
		hp.getContact().click();
		//driver.findElement(By.linkText("Contacts")).click();
		
		//step 4: Click on create contact look up image
		ContactsPage cp= new ContactsPage(driver);
		cp.getCreateContact().click();
		
		
		
		//step 5: Create contact with madatory fields
		CreateContactsPage ccp= new CreateContactsPage(driver);
		ccp.getLastname().sendKeys(LASTNAME);
		
		
		
		
		//Step 6: save and verify
		ccp.getSaveButton().click();
	
		ContactInforamtionPage cip=new ContactInforamtionPage(driver);
		String lastEle = cip.getContactInformation().getText();
		
		
		if(lastEle.contains(LASTNAME)) {
			System.out.println(lastEle+"....pass");
		}
		else {
			System.out.println(lastEle+"....failed");
		}
		
		//Step 8: logout of application
		WebElement logoutEle = hp.getAdministrator();
		//WebDriverUtility wdu= new WebDriverUtility();
		wutil.toMouseHover(driver, logoutEle);
		hp.getSignout().click();
		
		
		//Step 9: close brwoser
		driver.quit();
		

	}

}
